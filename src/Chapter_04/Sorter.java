package Chapter_04;

public class Sorter {
    private short[] arr = new short[5];

    public Sorter() {
        for(int i=0; i<5; i++) {
            int n = (int)(Math.random() * 1000);
            n %= 10;

            arr[i] = (short)n;
            System.out.println("arr[" + i + "] = " + n);
        }
    }

    public void GenerateRandom() {
        System.out.println("랜덤!!!");
        for(int i=0; i<5; i++) {
            int n = (int)(Math.random() * 1000);
            n %= 10;

            arr[i] = (short)n;
            System.out.println("arr[" + i + "] = " + n);
        }
    }

    public void DoSort() {
        for(int i=0; i<4; i++) {
            for (int j = i + 1; j < 5; j++) {
                if (arr[i] > arr[j])
                    swap(i, j);
            }
        }

        System.out.println("소트 완료!!!");
        for(int i=0; i<5; i++) {
            System.out.println("arr[" + i + "] = " + arr[i]);
        }
    }

    public void DoBubbleSort() {
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

    private void swap(int a, int b) {
        short tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}