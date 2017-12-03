package cmpe.dos.controller;

import cmpe.dos.response.JsonResponse;
import cmpe.dos.service.RewardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static cmpe.dos.config.security.UserRole.PRIV_ADMIN;

/**
 * Created by Vencci on 01/12/2017.
 */
@RestController
@Api(tags = {"Reward"})
@SwaggerDefinition(tags = { @Tag(name="Reward Controller", description="Distribute Coupons to Users")})
@Transactional(rollbackFor = Exception.class)
public class RewardController extends AbstractController{
    @Autowired
    RewardService rewardSvc;

    @ApiOperation(value = "Distribute Coupon tp Loyal Customer", response = JsonResponse.class)
    @GetMapping("Reward/{years}/{times}/{values}/{duration}")
    @PreAuthorize(PRIV_ADMIN)
    public ResponseEntity<JsonResponse> giveCoupon(@PathVariable Integer years, @PathVariable Integer times, @PathVariable Float values, @PathVariable Integer duration) {
        Boolean isGiven = rewardSvc.addNewCoupon(years, times, values, duration);
        return success("RewardGiven", isGiven);
    }
}
