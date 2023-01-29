package Chapter_06;

public class ThreadT extends Thread{
    public void run() {
        for(int i=0; i<100; i++)
            System.out.println("스레드 진행중..." + i);
    }
}

class ThreadR implements Runnable {
    public void run() {
        for(int i=0; i<100; i++)
            System.out.println("러너블 스레드 진행중..." + i);
    }
}

class Thread3 implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++)
            System.out.println("<" + Thread.currentThread().getName() + ">");
        for (int i = 0; i < 1000; i++) {
        }
    }
}


class SleepThread implements Runnable {
    public void run() {
        System.out.println("카운트다운 5초");
        for(int i=5; i>=0; i--)
        {
            System.out.println(i);
            if (i!=0) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
        System.out.println("종료");
    }
}

class YeildThread implements Runnable {
    @Override
    public void run() {
        for(int i=0; i<30; i++) {
//            try {
//                Thread.sleep(1);
//            }
//            catch ( Exception e) {
//                System.out.println(e);
//            }
            System.out.print("⇧");
            Thread.yield();
        }
    }
}

class NormalThread implements Runnable {
    @Override
    public void run() {
        for(int i=0; i<30; i++) {
//            try {
//                Thread.sleep(1);
//            }
//            catch ( Exception e) {
//                System.out.println(e);
//            }
            System.out.print("⚡︎");
        }
    }
}


class JoinThread1 implements Runnable {
    @Override
    public void run() {
        for(int i=0; i<10; i++) {
            System.out.println(Thread.currentThread().getName() + " ===> " + i);
        }
        System.out.println(Thread.currentThread().getName() + " 종료");
    }
}

class SyncThread implements Runnable {
    Ticketing tk = new Ticketing();
    @Override
    public void run() {
        tk.Ticketing();
    }
}


class Ticketing {
    protected int ticketNumber = 1;
    public synchronized void Ticketing() {
        if ( ticketNumber > 0) {
            System.out.println(Thread.currentThread().getName() + "가 티켓팅 성공");
            ticketNumber -= 1;
        }
        else {
            System.out.println(Thread.currentThread().getName() + "가 티켓팅 실패");
        }
        System.out.println(Thread.currentThread().getName() + "가 티켓팅 시도후 남은 티켓수 : " + ticketNumber);
    }
}
