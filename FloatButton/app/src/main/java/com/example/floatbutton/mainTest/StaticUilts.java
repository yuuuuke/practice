package com.example.floatbutton.mainTest;

import java.security.MessageDigest;

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
}
