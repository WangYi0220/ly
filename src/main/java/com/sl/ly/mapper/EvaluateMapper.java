package com.sl.ly.mapper;

import com.sl.ly.pojo.Evaluate;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EvaluateMapper {
   void addEvaluate(@Param("evaluates") List<Evaluate> evaluates);

   List<Map<String, Object>> getProjectEvaluateListBySponsorUUID(@Param("sponsorUUID") String sponsorUUID);

   List<Map<String, Object>> getCollectList(@Param("sponsorUUID") String sponsorUUID);
}
