package com.google.jdbc;

/**
 * @Author: jerryXia
 * @Description: 业务id生成工具
 * @Date: Created in 9:57 AM 16/01/2018
 * @Modified By:
 */
public class BidUtil {

    /**
     * 获取Bid
     * @return bid
     */
    public static String getBid(){
        String bidStr = null;
        bidStr = BidUtilBase.getFmtUUID()+BidUtilBase.getTimeFlagSys();
        return bidStr;
    }

    /**
     * 解码bid
     * @param bidStr
     * @return
     */
    public static String[] decodeBid(String bidStr){
        String[] bidArray = BidUtilBase.decodeBid(bidStr);
        return bidArray;
    }

    public static void main(String[] args) {
        System.out.println(getBid());
    }

}
