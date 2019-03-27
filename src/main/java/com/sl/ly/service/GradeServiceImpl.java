package com.sl.ly.service;

import com.sl.ly.mapper.GradeMapper;
import com.sl.ly.pojo.Grade;
import com.sl.ly.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GradeServiceImpl implements GradeService {
    @Autowired
    private GradeMapper gradeMapper;

    /**
     * 添加评分项
     *
     * @param grade
     * @return
     */
    @Override
    public String addGrade(Grade grade) {
        String uuid = UUIDUtils.getUUID();
        grade.setGradeUUID(uuid);
        gradeMapper.addGrade(grade);
        return uuid;
    }

    /**
     * 删除评分项
     * @param gradeUUID
     */
    @Override
    public void delGrade(String gradeUUID) {
        gradeMapper.delGrade(gradeUUID);
    }

    /**
     * 更新评分项
     * @param grade
     */
    @Override
    public void updateGrade(Grade grade) {
        gradeMapper.updateGrade(grade);
    }

    /**
     * 根据路演编号查询所有评分项
     * @param sponsorUUID
     * @return
     */
    @Override
    public List<Grade> getGradeListBySponsorUUID(String sponsorUUID) {
        return gradeMapper.getGradeListBySponsorUUID(sponsorUUID);
    }
}
