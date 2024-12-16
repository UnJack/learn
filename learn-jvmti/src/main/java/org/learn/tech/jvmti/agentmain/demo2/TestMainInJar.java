package org.learn.tech.jvmti.agentmain.demo2;

/**
 * @create by jimjian on 2017/11/14 11:11
 **/
public class TestMainInJar {
    public static void main(String[] args) throws InterruptedException {
        String s="ssss";
        System.out.println("sss:"+s.split(",").length);

        String s1="   yf-sec-hids-web-staging01.yf.sankuai.com ";
        System.out.println("s1 = " + s1);
        System.out.println(s1.trim());
//        System.out.println(new TransformerTarget().getObject());
//        int count = 0;
//        while (true) {
//            Thread.sleep(500);
//            count++;
//            String number = new TransformerTarget().getObject();
//            System.out.println(number);
//            if ("this is china...".equals(number) || count >= 10) {
//                break;
//            }
//        }
    }
}