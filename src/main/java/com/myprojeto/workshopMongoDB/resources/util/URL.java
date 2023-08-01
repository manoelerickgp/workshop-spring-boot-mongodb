package com.myprojeto.workshopMongoDB.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {

    public static String decode(String text){
        try {
            return URLDecoder.decode(text, "utf-8");
        }
        catch (UnsupportedEncodingException e) {
            return "";
        }
    }
}
