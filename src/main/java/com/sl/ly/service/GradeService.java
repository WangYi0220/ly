package com.sl.ly.service;

import com.sl.ly.pojo.Grade;

import java.util.List;

public interface GradeService {
    String addGrade(Grade grade);

    void delGrade(String gradeUUID);

    void updateGrade(Grade grade);

    List<Grade> getGradeListBySponsorUUID(String sponsorUUID);
}
