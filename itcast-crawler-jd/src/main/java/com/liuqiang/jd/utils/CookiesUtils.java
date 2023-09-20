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
        map.put("thor","270FAE00B309BA8AA319F2A93046085F942185351D6E8A329078FC310118B00BBFC" +
                "70BA2EFC82E68C682F504C87B4203A9CD4A761CDD9D467B18FAB86C2A7733105F3D91D1E7C" +
                "4ACEFE97FABEA189BA175D18ADF47A04690BD99CB160B1105CC451684D8D82BC6D81EF0D8C" +
                "9E6EBED32E088AE521CE21EE728471F1B5547CE265BAB2AE4CE36BD625F5D2F01D7EC0A906" +
                "AACD655F903B85AC19374A92FBF3483");
        return map;

    }

}
