package com.sl.ly.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Judge implements Serializable {
    private String judgeUUID;
    private String sponsorUUID;
    private String userUUID;
    private String judgeName;
    private String phone;
    private String organ;
    private String flag;
}
