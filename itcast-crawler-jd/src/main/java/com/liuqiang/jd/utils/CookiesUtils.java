package com.liuqiang.jd.utils;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: 设置Cookie
 * @date 2023/9/19 18:31
 */
@Component
public class CookiesUtils {

    public Map<String,String> GetCookie(){
        //解决京东安全界面跳转
        Map<String,String> map = new HashMap<>();
        map.put("thor","270FAE00B309BA8AA319F2A93046085F942185351D6E8A329078FC310118B00BA37E54A03F20D52C2C43F246E5CB81" +
                "A1742DE14602DE62E425E119CB62C9DEFCFE031A308C0907DB8A9FA5440F809F45505C784076" +
                "8DC62985A48F2C6633B0A12D25384815B50EA6F5678A6A5A07EE8538CE92AA8F393AFB85725D396724AC60A2D913A0E19" +
                "DFFA3210AA7BD1E39269AC6AFDE32AE5D926B2076717DA7BA70B1");
        return map;

    }

}
