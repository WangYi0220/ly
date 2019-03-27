package com.sl.ly.mapper;

import com.sl.ly.pojo.Sponsor;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SponsorMapper {
    void createSponsor(Sponsor sponsor);

    Sponsor getSponsorBySponsorUUID(@Param("sponsorUUID") String sponsorUUID);

    void updateSponsor(Sponsor sponsor);

    List<Map<String, Object>> getSponsorListByUserUUID(@Param("userUUID") String userUUID);

    void CheckStatus();

    Map<String, String> getProjectCode(@Param("sponsorUUID") String sponsorUUID);

    Map<String, String> getJudgeCode(@Param("sponsorUUID") String sponsorUUID);
}
