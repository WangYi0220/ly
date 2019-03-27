package com.sl.ly.config;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.config.WxMaInMemoryConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WxMaConfiguration {
    @Value("${wx.miniapp.config.appid}")
    private String appid;
    @Value("${wx.miniapp.config.secret}")
    private String secret;
    @Value("${wx.miniapp.config.msgDataFormat}")
    private String msgDataFormat;

    @Bean
    public WxMaService wxMaService(){
        WxMaInMemoryConfig config = new WxMaInMemoryConfig();
        config.setAppid(appid);
        config.setSecret(secret);
        config.setMsgDataFormat(msgDataFormat);
        WxMaService wxMaService = new WxMaServiceImpl();
        wxMaService.setWxMaConfig(config);
        return wxMaService;
    }
}
