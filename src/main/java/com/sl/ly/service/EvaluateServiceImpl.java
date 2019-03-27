package com.sl.ly.service;

import com.sl.ly.mapper.EvaluateMapper;
import com.sl.ly.pojo.Evaluate;
import com.sl.ly.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class EvaluateServiceImpl implements EvaluateService {
    @Autowired
    private EvaluateMapper evaluateMapper;

    /**
     * 评委打分
     * @param evaluates
     */
    @Override
    public void addEvaluate(List<Evaluate> evaluates) {
        evaluateMapper.addEvaluate(evaluates);
    }

    /**
     * 获取项目统计评分列表
     * @param sponsorUUID
     * @return
     */
    @Override
    public List<Map<String, Object>> getProjectEvaluateListBySponsorUUID(String sponsorUUID) {
        return evaluateMapper.getProjectEvaluateListBySponsorUUID(sponsorUUID);
    }

    /**
     * 根据主办方编号获取该路演下，所有项目的汇总情况
     * @param sponsorUUID
     * @return
     */
    @Override
    public List<Map<String, Object>> getCollectList(String sponsorUUID) {
        return evaluateMapper.getCollectList(sponsorUUID);
    }
}
