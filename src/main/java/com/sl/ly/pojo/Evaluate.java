package com.sl.ly.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Evaluate implements Serializable {
    private String evaluateUUID;
    private String sponsorUUID;
    private String gradeUUID;
    private String projectUUID;
    private int score;
    private String remark;
    private boolean flag;
    private boolean status;
}
