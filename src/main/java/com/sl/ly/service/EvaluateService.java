package com.sl.ly.service;

import com.sl.ly.pojo.Evaluate;

import java.util.List;
import java.util.Map;

public interface EvaluateService {
    void addEvaluate(List<Evaluate> evaluates);

    List<Map<String, Object>> getProjectEvaluateListBySponsorUUID(String sponsorUUID);

    List<Map<String, Object>> getCollectList(String sponsorUUID);
}
