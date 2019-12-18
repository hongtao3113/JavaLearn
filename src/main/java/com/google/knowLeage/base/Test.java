package com.google.knowLeage.base;

/**
 * @author wk
 * @Description:
 * @date 2019/9/29 15:52
 **/
public class Test {

    public static void main(String[] args) {

        float f = 3.4F;
        System.out.println(f);

        short s1 = 1;
        //s1=s1+1;  //编译错误
        s1 += 1;//查看.class 存在强转  short s1 = (short)(s1 + 1);
        System.out.println(s1);

        int i = 1;
        Integer i2 = 2;
        i = i2;
        i2 = i;
        //int与Integer可以相互转换

        //IntegerCache
        Integer i3 = -128;
        Integer i4 = -128;
        System.out.println(i3 == i4);//true
        Integer i5 = -129;
        Integer i6 = -129;
        System.out.println(i5 == i6);//false
        Integer i7 = 128;
        Integer i8 = 128;
        Integer i9 = 127;
        Integer i10 = 127;
        System.out.println(i7 == i8);//false
        System.out.println(i9 == i10);//true
        long l = 1;
        // switch 不用传long类型的，Java7及以后可以传String类型的
        String str = "";
        Integer x = 1;
        // 只能抛出运行时异常，不能抛出new Exception("")否则编译不通过
        switch (x) {
            case 1: {
                System.out.println("I am fine,thanks and you ");
                throw new RuntimeException("");
            }
            case 2: {
                System.out.println("I am fine,thanks and you ?");
            }
        }
    }
}
