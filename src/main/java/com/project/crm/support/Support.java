package com.project.crm.support;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Support {

    public static void write(String str, HttpServletResponse res) {
        try {
            res.getOutputStream().write(str.getBytes());
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    
}
