package Chapter_06;

public class ThreadTest {
    public static void main(String[] args) {

//        ThreadT t1 = new ThreadT();
//        Runnable t2 = new ThreadR();
//        Thread t = new Thread(t2);
//        t1.start();
//        t.start();
//
//        for(int i=0; i<10; i++)
//            System.out.println("메인 함수에서 진행중..." + i);

//        Runnable t = new Thread3();
//        Thread t1 = new Thread(t, "강호동 스레드");
//        t1.setPriority(1); // 우선 순위 1로 지정
//        System.out.println("t1의 우선순위 : " + t1.getPriority());
//
//        Thread t2 = new Thread(t, "유재석 스레드");
//        System.out.println("t2의 우선순위 : " + t2.getPriority());
//
//        Thread t3 = new Thread(t, "신동엽 스레드");
//        t3.setPriority(10);
//        System.out.println("t3의 우선순위 : " + t3.getPriority());
//
//        t2.start();
//        t3.start();
//        t1.start();


//            SleepThread thread = new SleepThread();
//            Thread t1 = new Thread(thread, "Sleep Thread");
//            t1.start();


//        YeildThread r1 = new YeildThread();
//        Thread t1 = new Thread(r1, "Yiel Thread");
//
//        NormalThread r2 = new NormalThread();
//        Thread t2 = new Thread(r2, "Normal Thread");
//
//        t1.start();
//        t2.start();



//        JoinThread1 r1 = new JoinThread1();
//        Thread t1 = new Thread(r1, "Join Thread 1");
//
//        JoinThread1 r2 = new JoinThread1();
//        Thread t2 = new Thread(r2, "Join Thread 2");
//
//        t2.start();
//        try{
//            t2.join();
//        }
//        catch (Exception e) {
//            System.out.println(e);
//        }
//
//        t1.start();
//        try{
//            t1.join();
//        }
//        catch (Exception e) {
//            System.out.println(e);
//        }
//
//        for (int i=0; i<10; i++) {
//            System.out.println("메인에서 실행중..." + i);
//        }

        //
        SyncThread r1 = new SyncThread();
        Thread t1 = new Thread(r1, "A");
        Thread t2 = new Thread(r1, "B");
        Thread t3 = new Thread(r1, "C");

        t1.start();
        t2.start();
        t3.start();
    }
}
