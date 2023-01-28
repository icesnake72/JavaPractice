package Chapter_04;

public abstract class Sorter implements SortInterface {
    public static int lastId = 0;
    protected int id;
    protected long lastProcTime;
    protected short[] arr = new short[5];
    protected short[] arrResult = new short[5];

    public Sorter() {
        this.id = lastId++;
        lastProcTime = 0;
        this.GenerateRandom();
    }

    @Override
    public String toString() {
        return this.getClass() + "(id) = " + id;
    }

    public void GenerateRandom() {
        System.out.println(this + " 랜덤!!! 소팅 준비 완료!");
        for(int i=0; i<5; i++) {
            int n = (int)(Math.random() * 1000);
            n %= 100;

            arr[i] = (short)n;
            // System.out.println("arr[" + i + "] = " + n);
        }
        arrResult = arr.clone();
    }

    protected void swap(int a, int b) {
        short tmp = arrResult[a];
        arrResult[a] = arrResult[b];
        arrResult[b] = tmp;
    }

    public void PrintResult(){

        System.out.print("Before : ");
        for (int i = 0; i < 5; i++) {
            System.out.print(arr[i]);
            System.out.print(", ");
            //            System.out.println("arr[" + i + "]=" + arr[i]
            //                                + " ===> arr[" + i + "]=" + arrResult[i]);
        }
        System.out.println();
        System.out.print("After : ");
        for (int i = 0; i < 5; i++) {
            System.out.print(arrResult[i]);
            System.out.print(", ");
        }

        System.out.println();
    }


    public abstract void DoSort();

    public long GetProcTime() {
        return lastProcTime;
    }
}

class SeqSorter extends Sorter {
    public void DoSort() {
        System.out.println(this + "시퀀셜 소트 시작!!!");
        long start = System.currentTimeMillis();
        for(int i=0; i<4; i++) {
            for (int j = i + 1; j < 5; j++) {
                if (arrResult[i] > arrResult[j])
                    swap(i, j);
//                lastProcTime++;
            }
        }
        long end = System.currentTimeMillis();
        lastProcTime = end - start;

//        for(int i=0; i<5; i++) {
//            System.out.println("arr[" + i + "] = " + arr[i]);
//        }
        PrintResult();
        System.out.println(this + "시퀀셜 소트 완료!!!");
    }


}

class BubbleSorter extends Sorter {
    public void DoSort() {
//        lastProcTime = 0;
        long start = System.currentTimeMillis();
        System.out.println(this + "버블 소트 시작!!!");
        // long start = System.currentTimeMillis();
        for(int i=4; i>0; i--) {
            for(int j=0; j<i; j++) {
                if ( arrResult[j]>arrResult[j+1])
                    swap(j, j + 1);

//                lastProcTime++;
            }
        }
         long end = System.currentTimeMillis();
         lastProcTime = end - start;

//        for(int i=0; i<5; i++) {
//            System.out.println("arr[" + i + "] = " + arr[i]);
//        }

        PrintResult();
        System.out.println(this + "버블 소트 완료!!!");
    }
}
