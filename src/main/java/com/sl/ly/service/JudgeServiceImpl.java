package com.sl.ly.service;

import com.sl.ly.mapper.JudgeMapper;
import com.sl.ly.pojo.Judge;
import com.sl.ly.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class JudgeServiceImpl implements JudgeService {
    @Autowired
    private JudgeMapper judgeMapper;

    /**
     * 添加评委
     * @param judge
     */
    @Override
    public String addJudge(Judge judge) {
        String uuid = UUIDUtils.getUUID();
        judge.setJudgeUUID(uuid);
        judgeMapper.addJudge(judge);
        return uuid;
    }

    /**
     * 根据用户编号获取评委方封面列表
     * @param userUUID
     * @return
     */
    @Override
    public List<Map<String, Object>> getJudgeListByUserUUID(String userUUID) {
        return judgeMapper.getJudgeListByUserUUID(userUUID);
    }

    /**
     * 根据项目编号获取评委列表
     * @param sponsorUUID
     * @return
     */
    @Override
    public List<Map<String, Object>> getJudgeListBySponsorUUID(String sponsorUUID) {
        return judgeMapper.getJudgeListBySponsorUUID(sponsorUUID);
    }

    /**
     * 更新评委信息
     * @param judge
     */
    @Override
    public void updateJudgeByJudgeUUID(Judge judge) {
        judgeMapper.updateJudgeByJudgeUUID(judge);
    }

    /**
     * 删除评委
     * @param judgeUUID
     */
    @Override
    public void delJudgeByJudgeUUID(String judgeUUID) {
        judgeMapper.delJudgeByJudgeUUID(judgeUUID);
    }
}
