package com.google.jdbc;



import java.util.UUID;

/**
 * @Author: jerryXia
 * @Description: 业务id生成工具基础类
 * @Date: Created in 9:57 AM 16/01/2018
 * @Modified By:
 */
public class BidUtilBase {

    /**
     * 获取随机UUID
     * @return
     */
    protected static String getUUID(){
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }

    /**
     * 获取系统时间后四位时间戳
     * @return
     */
    protected static String getTimeFlagSys(){
        long time = System.currentTimeMillis();
        String timeStr = String.valueOf(time);
        return timeStr.substring(timeStr.length()-4,timeStr.length());
    }

    /**
     * 获取格式化的uuid：无 -
     * @return
     */
    protected static String getFmtUUID(){
        String uuidStr = getUUID();
        String uuidFmt = uuidStr.replaceAll("-","");
        return uuidFmt;
    }


    /**
     * 获取Bid
     * @param clazz
     * @return
     */
    protected static String getBid(Class clazz){
        String bidStr = null;
        bidStr = getFmtUUID()+getTimeFlagSys();
        return bidStr;
    }

    /**
     * 解码bid
     * @param bidStr
     * @return
     */
    protected static String[] decodeBid(String bidStr){
        String[] bidArray = new String[2];
        if(bidStr!=null){
            String uuid = bidStr.substring(0,32);
            String timeFlag = bidStr.substring(32);
            bidArray[0]=uuid;
            bidArray[1]=timeFlag;
        }
        return bidArray;
    }

}
