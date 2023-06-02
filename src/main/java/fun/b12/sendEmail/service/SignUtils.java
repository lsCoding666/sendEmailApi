package fun.b12.sendEmail.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class SignUtils {


    public static void main(String[] args) {
        SortedMap<String,Object> sortedMap = new TreeMap<String,Object>();
        sortedMap.put("pid", "1089");
        sortedMap.put("type", "alipay");
        sortedMap.put("out_trade_no", "1");
        sortedMap.put("notify_url", "https://2345.com");
        sortedMap.put("return_url", "https://2345.com");
        sortedMap.put("name", "测试");
        sortedMap.put("money", "0.01");
        sortedMap.put("sign_type","MD5" );
        sortedMap.put("sign",  createSign(sortedMap));
    }

    public static String createSign(SortedMap parameters){

        StringBuffer sb = new StringBuffer();
        Set es = parameters.entrySet();//所有参与传参的参数按照accsii排序(升序)
        Iterator it = es.iterator();
        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            String k = (String)entry.getKey();
            Object v = entry.getValue();
            if(null != v && !"".equals(v)
                    && !"sign".equals(k) && !"key".equals(k)) {
                sb.append(k +"=" + v+"&");
            }
        }

        sb.append("key="+"UitUQS8GC4CnUi8xZSLwWBiP1wTjaMqU");
                System.out.println("签名字符串:"+sb.toString());

        String sign = MD52(sb.toString()).toUpperCase();
        System.out.println("签名结果:"+sign);
        return sign;

    }
    public static String MD52(String input) {
        if(input == null || input.length() == 0) {
            return null;
        }
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(input.getBytes());
            byte[] byteArray = md5.digest();

            char[] hexDigits = {'0','1','2','3','4','5','6','7','8','9', 'a','b','c','d','e','f'};
            // 一个字节对应两个16进制数，所以长度为字节数组乘2
            char[] charArray = new char[byteArray.length * 2];
            int index = 0;
            for (byte b : byteArray) {
                charArray[index++] = hexDigits[b>>>4 & 0xf];
                charArray[index++] = hexDigits[b & 0xf];
            }
            return new String(charArray);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }


}