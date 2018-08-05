package init.liu;

/**
 * Create by : liu
 * Create on : 2018/8/5
 * Create for : 借书线程
 */
public class Borrow extends Thread {

    private Library library;

    public Borrow(Library library) {
        this.library = library;
    }

    @Override
    public void run() {
        while (true) {
            library.borrow();
        }
    }
}
