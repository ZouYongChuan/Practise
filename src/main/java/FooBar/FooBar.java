package FooBar;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class FooBar {
    private int n;
    final private BlockingQueue<Integer> barQueue;
    final private BlockingQueue<Integer> fooQueue;

    public FooBar(final int n) {
        this.n = n;
        barQueue = new LinkedBlockingDeque<>();
        fooQueue = new LinkedBlockingDeque<>();
    }

    public void foo(final Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            fooQueue.take();
            printFoo.run();
            barQueue.put(i);
        }
    }

    public void bar(final Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            barQueue.take();
            printBar.run();
            fooQueue.put(i);
        }
    }
}
