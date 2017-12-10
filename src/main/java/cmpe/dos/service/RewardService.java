package cmpe.dos.service;

import java.util.List;

import cmpe.dos.dto.CouponDto;
import cmpe.dos.entity.Reward;

public interface RewardService {

    public List<Reward> getRewardsByUser(String username);

    public Reward getValidCoupon(String couponId);

    public void DeleteUsedCoupon(Reward reward);

    public Boolean addNewCoupon(CouponDto rewardDto);

    public Boolean sendCommentReward(String username);

}
