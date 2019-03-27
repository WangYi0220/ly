package com.sl.ly.service;

import com.sl.ly.pojo.Judge;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface JudgeService {
    String addJudge(Judge judge);

    List<Map<String, Object>> getJudgeListByUserUUID(@Param("userUUID") String userUUID);

    List<Map<String, Object>> getJudgeListBySponsorUUID(String sponsorUUID);

    void updateJudgeByJudgeUUID(Judge judge);

    void delJudgeByJudgeUUID(String judgeUUID);
}
