package com.google.test;

import java.util.ArrayList;
import java.util.List;

public class TestInputStream {

    public static void main(String[] args){

        List<String> list = new ArrayList<>();
        list.add("01160001|+|xxxx+|74153560-0|+|52370200MJD821637A|+|娌抽挗鑲′唤鏈夐檺鍏�?徃鎵垮痉鍒嗗叕鍙�?+|69922773-4|+|null|+|2110|+|TX1810190146|+|2018-10-19 09:56:16.0|+|2019-04-17 00:00:00.0|+|01|+|10000.00|+|10000.00");
        list.add("01160001|+|鎵垮痉鏂版柊鏈烘鍒堕�犳湁闄愬叕鍙�?+|74153560-0|+|52370200MJD821637A|+|娌抽挗鑲′唤鏈夐檺鍏�?徃鎵垮痉鍒嗗叕鍙�?+|69922773-4|+|null|+|2110|+|TX1810190146|+|2018-10-19 09:56:16.0|+|2019-04-17 00:00:00.0|+|01|+|10000.00|+|10000.00");
        list.add("01160001|+|娌冲寳浼楅懌鑷磋儨閲戝睘鍒跺搧鏈夐檺鍏徃|+||+|524101003268790780|+|鍞愬北閽㈤搧闆嗗洟鏈夐檺璐ｄ换鍏�?徃|+|null|+|911302001047928234|+|2110|+|TX1810240192|+|2018-10-24 18:06:02.0|+|2019-02-21 00:00:00.0|+|01|+|10000.00|+|10000.00");
        System.out.println(list.get(2));
        String s = list.get(0);
        String[] strings = s.split("\\|\\+\\|");
        System.out.println(strings.length);
        for(String i:strings){
            System.out.println(i);
        }

    }
}
