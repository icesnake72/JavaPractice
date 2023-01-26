package Chapter_04;

public abstract class Sorter {
    protected short[] arr = new short[5];

    public Sorter() {
        this.GenerateRandom();
//        for(int i=0; i<5; i++) {
//            int n = (int)(Math.random() * 1000);
//            n %= 10;
//
//            arr[i] = (short)n;
//            System.out.println("arr[" + i + "] = " + n);
//        }
    }

    public void GenerateRandom() {
        System.out.println("랜덤!!! 소팅 준비 완료!");
        for(int i=0; i<5; i++) {
            int n = (int)(Math.random() * 1000);
            n %= 10;

            arr[i] = (short)n;
            System.out.println("arr[" + i + "] = " + n);
        }
    }

    protected void swap(int a, int b) {
        short tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public abstract void DoSort();
}

class SeqSorter extends Sorter {
    public void DoSort() {
        for(int i=0; i<4; i++) {
            for (int j = i + 1; j < 5; j++) {
                if (arr[i] > arr[j])
                    swap(i, j);
            }
        }

        System.out.println("시퀀셜 소트 완료!!!");
        for(int i=0; i<5; i++) {
            System.out.println("arr[" + i + "] = " + arr[i]);
        }
    }
}

class BubbleSorter extends Sorter {
    public void DoSort() {
        for(int i=4; i>0; i--) {
            for(int j=0; j<i; j++) {
                if ( arr[j]>arr[j+1])
                    swap(j, j+1);
            }
        }

        System.out.println("버블 소트 완료!!!");
        for(int i=0; i<5; i++) {
            System.out.println("arr[" + i + "] = " + arr[i]);
        }
    }
}
