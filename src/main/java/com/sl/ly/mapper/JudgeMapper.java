package com.sl.ly.mapper;

import com.sl.ly.pojo.Judge;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface JudgeMapper {
    void addJudge(Judge judge);

    List<Map<String, Object>> getJudgeListByUserUUID(@Param("userUUID") String userUUID);

    List<Map<String, Object>> getJudgeListBySponsorUUID(@Param("sponsorUUID") String sponsorUUID);

    void updateJudgeByJudgeUUID(Judge judge);

    void delJudgeByJudgeUUID(@Param("judgeUUID") String judgeUUID);
}
