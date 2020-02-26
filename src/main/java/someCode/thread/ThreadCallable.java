package someCode.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadCallable implements Callable<String> {

    private int count = 20;

    @Override
    public String call() throws Exception {
        for (int i=count; i>0 ;i--){
            System.out.println(Thread.currentThread().getName() + "当前票数：" + i);
        }
        return "sale out";
    }

    public static void main(String[] args) {
        Callable<String> callable = new ThreadCallable();
        FutureTask<String> futureTask = new FutureTask<>(callable);
        FutureTask<String> futureTask2 = new FutureTask<>(callable);
        FutureTask<String> futureTask3 = new FutureTask<>(callable);
        Thread thread1 = new Thread(futureTask);
        Thread thread2 = new Thread(futureTask2);
        Thread thread3 = new Thread(futureTask3);

        thread1.start();
        thread2.start();
        thread3.start();
        try {
            System.out.println(futureTask.get());
            System.out.println(futureTask2.get());
            System.out.println(futureTask3.get());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
