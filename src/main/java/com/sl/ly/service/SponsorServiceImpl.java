package com.sl.ly.service;

import com.sl.ly.mapper.SponsorMapper;
import com.sl.ly.pojo.Sponsor;
import com.sl.ly.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class SponsorServiceImpl implements SponsorService {
    @Autowired
    private SponsorMapper sponsorMapper;


    /**
     * 创建路演
     *
     * @param sponsor
     * @return sponsorUUID
     */
    @Override
    public String createSponsor(Sponsor sponsor) {
        String sponsorUUID = UUIDUtils.getUUID();
        sponsor.setSponsorUUID(sponsorUUID);
        sponsorMapper.createSponsor(sponsor);
        return sponsorUUID;
    }

    /**
     * 根据路演编号查询路演详情(主办方)
     *
     * @param sponsorUUID
     * @return
     */
    @Override
    public Sponsor getSponsorBySponsorUUID(String sponsorUUID) {
        return sponsorMapper.getSponsorBySponsorUUID(sponsorUUID);
    }

    /**
     * 更新路演(主办方)
     *
     * @param sponsor
     * @return
     */
    @Override
    public void updateSponsor(Sponsor sponsor) {
        sponsorMapper.updateSponsor(sponsor);
    }

    /**
     * 根据用户编号获取主办方封面列表
     * @param userUUID
     * @return
     */
    @Override
    public List<Map<String, Object>> getSponsorListByUserUUID(String userUUID) {
        List<Map<String, Object>> sponsorListByUserUUID = sponsorMapper.getSponsorListByUserUUID(userUUID);
        return sponsorListByUserUUID;
    }

    /**
     * 检查路演状态
     */
    @Override
    @Scheduled(cron = "0 0 0 * * ?")//每天早上五点开始检查
    public void CheckStatus() {
        System.out.println("我是定时任务");
        sponsorMapper.CheckStatus();
    }

    /**
     * 获取项目邀请码
     * @param sponsorUUID
     * @return
     */
    @Override
    public Map<String, String> getProjectCode(String sponsorUUID) {
        return sponsorMapper.getProjectCode(sponsorUUID);
    }

    /**
     * 获取评委邀请码
     * @param sponsorUUID
     * @return
     */
    @Override
    public Map<String, String> getJudgeCode(String sponsorUUID) {
        return sponsorMapper.getJudgeCode(sponsorUUID);
    }
}
