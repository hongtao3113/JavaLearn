package com.google.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {

    public static void main(String[] args){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(sdf.format(date));
        timer1();
    }

    /**
     * 10s鍚庢墽琛岃鏂规�?
     */
    public static void timer1() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                System.out.println(sdf.format(new Date()));
            }
        }, 10000);// 璁惧畾鎸囧畾鐨勬椂闂磘ime,姝ゅ涓�?000姣�?
    }
}
