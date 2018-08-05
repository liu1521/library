package init.liu;

/**
 * Create by : liu
 * Create on : 2018/8/5
 * Create for : 图书馆借书测试类
 */

public class Test {
    public static void main(String[] args) {
        Library library = new Library();
        new Borrow(library).start();
        new Refund(library).start();
    }
}
