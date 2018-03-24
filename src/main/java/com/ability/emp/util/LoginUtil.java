package com.ability.emp.util;

import org.json.JSONObject;

import com.ability.emp.util.speechsynthesis.common.ConnUtil;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 使用登录凭证 code 获取 session_key 和 openid
 * 其中 session_key 是对用户数据进行加密签名的密钥
 * 为了自身应用安全，session_key 不应该在网络上传输
 * 
 * @author Devin
 * @since 2018-3-23
 */
public class LoginUtil {

	//小程序唯一标识
    public static final String APPID = "wx78d9aed7f986807f";
    //小程序的 app secret
    public static final String SECRET = "0cb0d7fb35ab8772ff7884da70c459b4";
    //登录时获取的 code
    //public static final String JS_CODE = "";
    //填写为 authorization_code
    public static final String GRANT_TYPE ="authorization_code";

    //URL
    private static final String url = "https://api.weixin.qq.com/sns/jscode2session";

    
    public static String resfresh(String JS_CODE) throws Exception {
        String getOpenidURL = url + "?appid="+APPID
                + "&secret=" + SECRET + "&js_code=" + JS_CODE
                + "&grant_type="+GRANT_TYPE;
        
        URL url = new URL(getOpenidURL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5000);
        String result = ConnUtil.getResponseString(conn);
        System.out.println("========"+result);
        String session_key = parseJson(result);
        return session_key;
    }

    
    private static String parseJson(String result) throws Exception {
        JSONObject json = new JSONObject(result);
        
        String openid = json.getString("openid");
        String session_key = json.getString("session_key");
        //String unionid = json.getString("unionid");
        System.out.println("openid"+openid+"==="+"session_key"+session_key);
        return session_key;
        //expiresAt = System.currentTimeMillis() + json.getLong("expires_in") * 1000;
    }
}
