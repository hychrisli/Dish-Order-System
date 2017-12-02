package cmpe.dos.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import cmpe.dos.dto.OrderHistoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import cmpe.dos.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.transaction.annotation.Transactional;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cmpe.dos.dto.CreditInfoDto;
import cmpe.dos.dto.DeliverInfoDto;
import cmpe.dos.dto.OrderDetailDto;
import cmpe.dos.entity.DeliveryInfo;
import cmpe.dos.entity.Dish;
import cmpe.dos.entity.Order;
import cmpe.dos.entity.OrderDishDetail;
import cmpe.dos.entity.OrderPayInfo;
import cmpe.dos.entity.Reward;
import cmpe.dos.exception.AppException;
import cmpe.dos.response.JsonResponse;
import cmpe.dos.service.CouponDictService;
import cmpe.dos.service.DefaultPaycardService;
import cmpe.dos.service.DeliveryInfoService;
import cmpe.dos.service.DeliverySettingService;
import cmpe.dos.service.DishService;
import cmpe.dos.service.OrderDishDetailService;
import cmpe.dos.service.OrderPayInfoService;
import cmpe.dos.service.OrderService;
import cmpe.dos.service.RewardService;
import cmpe.dos.utility.Param;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@CrossOrigin
@RestController
@Api(tags = {"Order"})
@SwaggerDefinition(tags = { @Tag(name="Order Controller", description="Create an order")})
@Transactional(rollbackFor = Exception.class)
public class OrderController extends AbstractController {

	@Autowired
    OrderService orderService;
	
	@Autowired
	DeliverySettingService deliverySettingService;
	
	@Autowired
	RewardService rewardService;
	
	@Autowired
	DeliveryInfoService deliveryInfoService;
	
	@Autowired
	OrderDishDetailService orderDishDetailService;
	
	@Autowired
	DefaultPaycardService defaultPaycardService;
	
	@Autowired
	OrderPayInfoService orderPayInfoService;
	
	@Autowired
	DishService dishService;
	
	@Autowired
	CouponDictService couponDictService;
	
	@ApiOperation(value = "Add An Order Record")
	@PostMapping("order")
	public ResponseEntity<JsonResponse> addOrder(){
		Order o1 = new Order("cust1", (short)1, new Date(), 15.89f, false );
		if(orderService.createOrder(o1))
			return created("created", o1);
		return conflict();
	}
	
	@ApiOperation(value = "get user default delivery info")
	@GetMapping("default/delivery")
	public ResponseEntity<JsonResponse> getDefaultDeliveryInfo(Principal principal){
		DeliverInfoDto diDto = orderService.getDefaultDeliverInfo(principal.getName());
		if (diDto != null)
			return success("default deliver info", diDto);
		return notFound();
	}
	
	@ApiOperation(value = "get user default paycard info")
	@GetMapping("default/paycard")
	public ResponseEntity<JsonResponse> getDefaultPaycardInfo(Principal principal) throws AppException{
		CreditInfoDto ciDto = defaultPaycardService.getDefaultPaycardInfo(principal.getName());
		if(ciDto != null)
			return success("default paycard info", ciDto);
		return notFound();
	}
	
	@ApiOperation(value = "create user default paycared info")
	@PostMapping("default/paycard")
	public  ResponseEntity<JsonResponse> setDefaultPaycardInfo(@RequestBody CreditInfoDto creditInfoDto, Principal principal) throws AppException{
	    return success("Added", defaultPaycardService.saveDefaultPaycard(principal.getName(), creditInfoDto));
	   
	}

	@ApiOperation(value = "get user history")
	@GetMapping ("orderHistory by username")
	public ResponseEntity<JsonResponse> getHistoryOrder(String username) {
		List historyOrder = orderService.getOrderByUsername(username);
		if (!historyOrder.isEmpty()) {
			return (success("orderHistory",historyOrder));
		} else {
			return notFound();
		}
	}

    ///reCheckOut Order
    @ApiOperation(value = "Check out for user's oreder")
    @PostMapping("order/ReCheckout")
    public ResponseEntity<JsonResponse> reCheckout(@RequestBody Param param, Principal principal, int orderid ) {
        String username = principal.getName();
        Short branchId = param.branchId;
        Float totalPrice = 0.00f;
        List<OrderDishDetail> detailList = new ArrayList<OrderDishDetail>();
        for (OrderDetailDto odDto : param.orderDetailList) {
            //Check whether we have enough inventory.
            Dish dish = dishService.getDish(branchId, odDto.getDishId());
            short inventory = (short) (dish.getInventoryQuantity() - odDto.getOrderQuantity());
            if (inventory < 0) {
                return runOutOfDishes(odDto.getDishName(), dish.getInventoryQuantity());
            }
            dish.setInventoryQuantity(inventory);
            dishService.updateDish(dish);

            totalPrice += odDto.getPrice() * odDto.getOrderQuantity();
            OrderDishDetail odd = new OrderDishDetail();
            odd.setDishId(odDto.getDishId());
            odd.setOrderQuantity(odDto.getOrderQuantity());
            detailList.add(odd);
        }

        if (param.isDelivery) {
            totalPrice += deliverySettingService.retrieveDeliverSetting(branchId).getFee();
        }

        if (param.usingCoupon) {
            Reward reward = rewardService.getValidCoupon(param.couponId);
            if (reward != null) {
                totalPrice -= couponDictService.getCouponInfo(param.couponId).getValue();
                rewardService.DeleteUsedCoupon(reward);
            } else {
                return noValidCoupon();
            }
        }
        List list11 = orderService.getInfoByID1(orderid);
        List list12 = orderService.getInfoByID2(orderid);
        OrderHistoryDto dto = orderService.getHistoryOrderDto(list11, list12);

        Order order = new Order(username, branchId, new Date(), totalPrice, param.isDelivery);
        orderService.createOrder(order);

        Integer orderId = order.getOrderId();
        for (OrderDishDetail odd : detailList) {
            odd.setOrderId(orderId);
            orderDishDetailService.create(odd);
        }

        if (param.isDelivery) {
            DeliveryInfo di = new DeliveryInfo();
            di.setOrderId(orderId);
            if (param.isDefaultAddress) {
                //DeliverInfoDto diDto = orderService.getDefaultDeliverInfo(username);
                di.setReceiverName(dto.getReceiverName());
                di.setStreet(dto.getStreet());
                di.setCity(dto.getCity());
                di.setState(dto.getState());
                di.setZipcode(dto.getZipcode());
                di.setPhone(dto.getPhone());
            } else {
                di.setReceiverName(param.diDto.getReceiverName());
                di.setStreet(param.diDto.getStreet());
                di.setCity(param.diDto.getCity());
                di.setState(param.diDto.getState());
                di.setZipcode(param.diDto.getZipcode());
                di.setPhone(param.diDto.getPhone());
            }
            deliveryInfoService.creat(di);
        }

        OrderPayInfo opi = new OrderPayInfo();
        opi.setOrderId(orderId);
        if (param.isDefaultPaycard) {

            opi.setCardholderName(dto.getCardholderName());
            opi.setCardNum(dto.getCardNum());
            opi.setCardType(dto.getCardType());
            opi.setDate(dto.getDate());
        } else {
            opi.setCardholderName(param.ciDto.getCardholderName());
            opi.setCardNum(param.ciDto.getCardNum());
            opi.setCardType(param.ciDto.getCardType());
            opi.setDate(param.ciDto.getDate());
        }
        orderPayInfoService.create(opi);
        return success("checkout the order", true);
    }

    @ApiOperation(value = "Test hql")
    @GetMapping ("order/get orderhistory by order id")
    public ResponseEntity<JsonResponse> testHql(int s){
	    List list1 = orderService.getInfoByID1(s);
	    List list2 = orderService.getInfoByID2(s);
		OrderHistoryDto dto = orderService.getHistoryOrderDto(list1, list2);

	    return success("test", dto);
    }



	@ApiOperation(value = "Check out for user's oreder")
	@PostMapping("order/checkout")
	public ResponseEntity<JsonResponse> checkout(@RequestBody Param param, Principal principal ) throws AppException{
		String username = principal.getName();
		Short branchId = param.branchId;
		Float totalPrice = 0.00f;
		List<OrderDishDetail> detailList = new ArrayList<OrderDishDetail>();
		for(OrderDetailDto odDto : param.orderDetailList){
			//Check whether we have enough inventory.
			Dish dish = dishService.getDish(branchId, odDto.getDishId());
			short inventory = (short) (dish.getInventoryQuantity() - odDto.getOrderQuantity());
			if(inventory < 0){
				return runOutOfDishes(odDto.getDishName(), dish.getInventoryQuantity());
			}
			dish.setInventoryQuantity(inventory);
			dishService.updateDish(dish);
			
			totalPrice += odDto.getPrice() * odDto.getOrderQuantity();
			OrderDishDetail odd = new OrderDishDetail();
			odd.setDishId(odDto.getDishId());
			odd.setOrderQuantity(odDto.getOrderQuantity());
			detailList.add(odd);
		}
			
		if(param.isDelivery){
			totalPrice += deliverySettingService.retrieveDeliverSetting(branchId).getFee();
		}
		
		if(param.usingCoupon){
			Reward reward = rewardService.getValidCoupon(param.couponId);
			if(reward != null){
				totalPrice -= couponDictService.getCouponInfo(param.couponId).getValue();
				rewardService.DeleteUsedCoupon(reward);
			}
			else{
				return noValidCoupon();
			}
		} 
		
		Order order = new Order(username, branchId, new Date(), totalPrice, param.isDelivery);
		orderService.createOrder(order);
		
		Integer orderId = order.getOrderId();
		for(OrderDishDetail odd : detailList){
			odd.setOrderId(orderId);
			orderDishDetailService.create(odd);
		}
		
		if(param.isDelivery){
			DeliveryInfo di = new DeliveryInfo();
			di.setOrderId(orderId);
			if(param.isDefaultAddress){
				DeliverInfoDto diDto = orderService.getDefaultDeliverInfo(username);
				di.setReceiverName(diDto.getReceiverName());
				di.setStreet(diDto.getStreet());
				di.setCity(diDto.getCity());
				di.setState(diDto.getState());
				di.setZipcode(diDto.getZipcode());
				di.setPhone(diDto.getPhone());
			}
			else {
				di.setReceiverName(param.diDto.getReceiverName());
				di.setStreet(param.diDto.getStreet());
				di.setCity(param.diDto.getCity());
				di.setState(param.diDto.getState());
				di.setZipcode(param.diDto.getZipcode());
				di.setPhone(param.diDto.getPhone());
			}
			deliveryInfoService.creat(di);
		}
		
		OrderPayInfo opi = new OrderPayInfo();
		opi.setOrderId(orderId);
		if(param.isDefaultPaycard){
			CreditInfoDto ciDto = defaultPaycardService.getDefaultPaycardInfo(username);
			opi.setCardholderName(ciDto.getCardholderName());
			opi.setCardNum(ciDto.getCardNum());
			opi.setCardType(ciDto.getCardType());
			opi.setDate(ciDto.getDate());
		}
		else{
			opi.setCardholderName(param.ciDto.getCardholderName());
			opi.setCardNum(param.ciDto.getCardNum());
			opi.setCardType(param.ciDto.getCardType());
			opi.setDate(param.ciDto.getDate());
		}
		orderPayInfoService.create(opi);
		
		
		
/*		System.out.println(param.toString());
		System.out.println("total price is: " + totalPrice);
		System.out.println(reward.getRewardId()); */
		return success("checkout the order", true);
		//return conflict();
	}
}
