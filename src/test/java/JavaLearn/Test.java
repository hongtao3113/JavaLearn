package JavaLearn;

/**
 * @author wk
 * @Description:
 * @date 2019/7/5 16:41
 **/
public class Test {

    public static void main(String[] args) {
        String s1 = "通话",s2="重地";
        System.out.println(String.format("s1:%d s2:%d",s1.hashCode(),s2.hashCode()));
        Object o = new Object();
        Integer i1=127,i2=127;
        Integer i3=128,i4=128;
        Integer i5=-128,i6=-128;
        System.out.println(i1==i2
        );
        System.out.println(i3==i4
        );
        System.out.println(i5==i6
        );
        System.out.println("你哈".charAt(0));

    }
}
