package com.alan.uaa.utils;

import java.util.Base64;

public class Base64Util {

    public static String decoder(String str){
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decodedBytes = decoder.decode(str);
        return new String(decodedBytes);
    }

}
