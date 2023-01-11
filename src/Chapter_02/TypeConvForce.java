package Chapter_02;



public class TypeConvForce {

    static int DecToBin(int number) {
        int bin = 0;
        int count = 0;
        while (number != 0){
            int rem = number % 2;
            double temp = Math.pow(10, count);
            bin += rem * temp;
            number /= 2;

            count++;
        }
        return bin;
    }


    public static void main(String[] args) {
        int a = 2;
        System.out.println(a);
        int b = ~a;
        // System.out.println(b);
        System.out.println(DecToBin(a));
        System.out.println(DecToBin(b));
    }
}
