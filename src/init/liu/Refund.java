package init.liu;

/**
 * Create by : liu
 * Create on : 2018/8/5
 * Create for : 还书线程
 */

public class Refund extends Thread {

    private Library library;

    public Refund(Library library) {
        this.library = library;
    }

    @Override
    public void run() {
        while (true) {
            library.refund();
        }
    }
}
