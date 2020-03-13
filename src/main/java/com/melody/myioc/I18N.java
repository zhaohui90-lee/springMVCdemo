package com.melody.myioc;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public class I18N {
    public static void main(String[] args) {
        //
        Locale china = new Locale("zh","CN");
        System.out.println(china.getCountry());
        System.out.println(china.getLanguage());


    }
}
