package com.much12.citlibrary;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CitLibrary {
    public String encryptMD5(String e) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] b = e.getBytes();

            digest.update(b);
            b = digest.digest();

            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < b.length; i++) {
                String h = Integer.toHexString(0xFF & b[i]);

                if (h.length() < 2) {
                    h = "0" + h;
                }

                stringBuilder.append(h);
            }

            return stringBuilder.toString();
        } catch(NoSuchAlgorithmException ex) {
            return ex.getMessage();
        }
    }
}
