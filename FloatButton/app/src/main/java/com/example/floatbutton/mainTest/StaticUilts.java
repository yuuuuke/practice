package com.example.floatbutton.mainTest;

import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * description:
 *
 * @author zwp
 * @since 2021/7/21
 */
class StaticUilts {

    public final static String getMD5(String string) {
        byte[] unencodedPassword = string.getBytes();

        MessageDigest md = null;

        try {
            md = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            return string;
        }

        md.reset();
        md.update(unencodedPassword);
        byte[] encodedPassword = md.digest();
        StringBuffer buf = new StringBuffer();

        for (int i = 0; i < encodedPassword.length; i++) {
            if ((encodedPassword[i] & 0xff) < 0x10) {
                buf.append("0");
            }
            buf.append(Long.toString(encodedPassword[i] & 0xff, 16));
        }

        return buf.toString();
    }


    private String getSign(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        List<Map.Entry<String, String>> infoIds =
                new ArrayList(map.entrySet());
        //字母升序排序
        Collections.sort(infoIds, new Comparator<Map.Entry<String, String>>() {
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        String string = "";
        for (int i = 0; i < infoIds.size(); i++) {
            String value = infoIds.get(i).getValue();
            string += (infoIds.get(i).getKey() + "=" + value + "&");
        }
        string = string.substring(0, string.length() - 1);
        return getMD5(string);
    }

    public static void doReflect() {
        try {
            //拿到API
            Class cls = Class.forName("com.example.floatbutton.mainTest.staticDemo");
            Method getInstance = cls.getDeclaredMethod("getInstance");
            //拿到黑桃的实例了
            Object obj = getInstance.invoke(null);
            //调用切换账号功能
            Method method = obj.getClass().getMethod("doFunction");
            method.invoke(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
