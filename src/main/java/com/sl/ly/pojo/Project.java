package com.sl.ly.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Project implements Serializable {
    private String projectUUID;
    private String sponsorUUID;
    private String userUUID;
    private String linkMan;
    private String phone;
    private String projectName;
    private int flag;
}
