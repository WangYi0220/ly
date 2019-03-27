package com.sl.ly.service;

import com.sl.ly.pojo.Sponsor;

import java.util.List;
import java.util.Map;

public interface SponsorService {
    String createSponsor(Sponsor sponsor);

    Sponsor getSponsorBySponsorUUID(String sponsorUUID);

    void updateSponsor(Sponsor sponsor);

    List<Map<String, Object>> getSponsorListByUserUUID(String userUUID);

    void CheckStatus();

    Map<String, String> getProjectCode(String sponsorUUID);

    Map<String, String> getJudgeCode(String sponsorUUID);
}
