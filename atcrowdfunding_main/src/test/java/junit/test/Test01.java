package junit.test;
//test重载
public class Test01 {
    public static void main(String[] args) {
      A a = new B();
      test(a);
    }

    private static void test(A a) {
        System.out.println("aaaaaaaaaaa");
    }
    private static void test(B b) {
        System.out.println("bbbbbbbbb");
    }
    static  class A{}
    static  class B extends A{}
}
