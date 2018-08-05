package init.liu;

import java.util.LinkedList;

/**
 * Create by : liu
 * Create on : 2018/8/5
 * Create for : 图书馆,提供借书还书方法
 */

public class Library {

    //保存图书,方便记录剩余图书数量
    private LinkedList<Book> books = new LinkedList<>();

    public Library() {
        books.add(new Book());
    }

    //借书操作
    public synchronized void borrow() {
        while (books.size() == 0) {
            System.out.println("目前没有图书可借,请稍等片刻");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //唤醒等待中的线程
        this.notifyAll();
        books.removeFirst();
        System.out.println("借书成功,目前还剩" + books.size() + "本书");
        //方便观察,每次等待一秒
        try {
            this.wait(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void refund() {
        if (books.size() == 3) {
            System.out.println("库存已满,无需还书");
            try {
                this.wait(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return;
        }
        books.addLast(new Book());
        System.out.println("还书成功,目前还剩" + books.size() + "本书");
        //方便观察
        try {
            this.wait(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
