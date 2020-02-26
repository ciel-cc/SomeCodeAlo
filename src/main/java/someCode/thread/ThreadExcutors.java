package someCode.thread;

import java.util.concurrent.*;

public class ThreadExcutors {

    public static void main(String[] args) {
        ThreadPoolExecutor pool=new ThreadPoolExecutor(2,10,
                200, TimeUnit.MILLISECONDS,  new ArrayBlockingQueue<Runnable>(5));

        /**new ThreadPoolExecutor(1, 1,0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>())*/
        ExecutorService poolSingle = Executors.newSingleThreadExecutor();

        /**ThreadPoolExecutor(0, Integer.MAX_VALUE,60L, TimeUnit.SECONDS,new SynchronousQueue<Runnable>());*/
        ExecutorService poolCache = Executors.newCachedThreadPool();

        /**new ThreadPoolExecutor(nThreads, nThreads,0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());*/
        ExecutorService poolFix = Executors.newFixedThreadPool(5);

        /**super(corePoolSize, Integer.MAX_VALUE, 0, NANOSECONDS, new DelayedWorkQueue());*/
        ExecutorService delay = Executors.newScheduledThreadPool(2);

        /**阻塞队列*/
        LinkedBlockingQueue<Runnable> runnableLinkedBlockingDeque = new LinkedBlockingQueue<>();
        PriorityBlockingQueue<Runnable> priorityBlockingQueue = new PriorityBlockingQueue<>();
        SynchronousQueue<Runnable> synchronousQueue = new SynchronousQueue<>();

//        MyTask task9 = new MyTask(99);
        for(int i=0;i<14;i++) {
            MyTask task=new MyTask(i);
//            task9 = task;
            pool.execute(task);
            System.out.println("线程池中线程数目："+pool.getPoolSize()+"，队列中等待执行的任务数目："+
                    pool.getQueue().size()+"，已执行玩别的任务数目："+pool.getCompletedTaskCount());
        }
        System.out.println("执行完毕");
        /*pool.execute(task9);*/
        System.out.println("线程池中线程数目："+pool.getPoolSize()+"，队列中等待执行的任务数目："+
                pool.getQueue().size()+"，已执行玩别的任务数目："+pool.getCompletedTaskCount());
        pool.shutdown();
    }
}

class MyTask implements Runnable{
    private int num;
    public MyTask(int num) {
        this.num=num;
    }
    @Override
    public void run() {
        System.out.println("正在执行任务  "+num);
        try {
            Thread.currentThread().sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程"+num+"执行完毕");

    }
}
