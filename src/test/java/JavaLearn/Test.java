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
    }
}
