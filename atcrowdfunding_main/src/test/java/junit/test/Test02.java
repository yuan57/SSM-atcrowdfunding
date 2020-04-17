package junit.test;

import java.util.List;

public class Test02 {
    public static void main(String[] args) throws InterruptedException {
/*
        String str = null;
        tr.equals("?"); //成员方法：依赖于对象调用
*/

        /*Thread t = null;
        t.sleep(3000); //静态方法，正常是通过的类的名称来调用，而不推荐对象来调用*/

/*        String i = "1";
        int j = Integer.parseInt(i);
        System.out.println(j);*/

/*
        Integer i = null;
        int j = i ;//自动拆箱
        System.out.println(j);
*/

        List<String> list = null ;
        for(String str : list){
        System.out.println(str);
        }


    }
}
