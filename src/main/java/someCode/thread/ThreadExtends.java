package someCode.thread;

public class ThreadExtends extends Thread {

    @Override
    public void run() {
        for (int i=0; i<10; i++){
            System.out.println(Thread.currentThread() + ":" + i);
        }
    }

    public static void main(String[] args) {
        ThreadExtends threadExtends1 = new ThreadExtends();
        ThreadExtends threadExtends2 = new ThreadExtends();
        ThreadExtends threadExtends3 = new ThreadExtends();

        threadExtends1.start();
        threadExtends2.start();
        threadExtends3.start();

    }
}
