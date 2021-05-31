package com.much12.citlib;

import java.security.MessageDigest;

public class CitLibrary {
    public String encryptMD5(String textoencrypt) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] bytes = textoencrypt.getBytes();

            digest.update(bytes);
            bytes = digest.digest();

            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                String h = Integer.toHexString(0xFF & bytes[i]);

                if (h.length() < 2) {
                    h = "0" + h;
                }

                stringBuilder.append(h);
            }

            return stringBuilder.toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
