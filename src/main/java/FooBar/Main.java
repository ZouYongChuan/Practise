package FooBar;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOGGER= LoggerFactory.getLogger(Main.class);
    public static void main(final String[] args) throws InterruptedException {
        final FooBar fooBar = new FooBar(3);
        final PrintFoo printFoo = new PrintFoo();
        final PrintBar printBar = new PrintBar();
        new Thread(){
            @Override
            public void run(){
                try {
                    fooBar.foo(printFoo);
                } catch (InterruptedException e) {
                    LOGGER.error(e.getMessage());
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run(){
                try {
                    fooBar.bar(printBar);
                } catch (InterruptedException e) {
                    LOGGER.error(e.getMessage());
                }
            }
        }.start();
    }
}
