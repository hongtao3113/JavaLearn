package com.google.lang;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestString {

        public static void main(String[] args) {
                String s = "2018-12-10T09:07:57.350+0000";
                String[] strings = s.split("T");
                System.out.println(strings[0]);
                System.out.println(strings[1].length());
                String string2 = strings[1].substring(0,8);
                System.out.println(string2);
                String d = new StringBuffer(strings[0]).append(" ").append(string2).toString();
                System.out.println(d);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try {
                        System.out.println(sdf.parse(d));
                } catch (ParseException e) {
                        e.printStackTrace();
                }
                String s3 = "911304045632003998";
                System.out.println(s3.substring(8,s3.length()-1));

        }

}
