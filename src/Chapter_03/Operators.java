package Chapter_03;

class A{}
class B extends A{}

public class Operators {
    public static void main(String[] args) {
        int a = 10;
        int b = 3;
        System.out.println(a+b);
        System.out.println(a-b);
        System.out.println(a*b);
        System.out.println(a/b);
        System.out.println(a%b);
        System.out.println("\n");

        // 단항 연산자
        // 부호 연산자
        a = -1;
        b = 2;
        System.out.println(a);
        System.out.println(-b);
        System.out.println(+a);
        System.out.println(b);
        System.out.println("\n");

        // 논리 부정 연산자
        boolean c = true;
        boolean d = false;
        boolean e = !d;
        System.out.println(c);
        System.out.println(!c);
        System.out.println(d);
        System.out.println(e);
        System.out.println("\n");

        int $name = 10;
        System.out.println($name+"\n");

        // 증감 연산자
        a = 1;
        System.out.println("a=" + a);   // a=1
        a++;                            // a=2
        System.out.println("a=" + a);   // a=2
        System.out.println("a=" + ++a); // a=3
        System.out.println("a=" + a++); // a=3
        System.out.println("a=" + a);   // a=4
        System.out.println("\n");

        // 비교 연산자
        // 대소비교 연산자
        int a2 = 10;
        int b2 = 20;
        int c2 = 30;
        System.out.println(a2 < b2);        // true
        System.out.println(a2 > b2);        // false
        System.out.println(a2+b2 <= c2);    // true
        System.out.println(a2+b2 >= c2);    // true
        System.out.println("\n");

        // 등가비교 연산자
        double f1 = 3.14;
        double f2 = 5.14;
        System.out.println(a==b);   // false
        System.out.println(a!=b);   // true

        String s1 = "Hello JAVA!";
        System.out.println(s1.equals("Hello java!"));   // false
        System.out.println(s1.equals("Hello JAVA!"));   // true
        System.out.println("\n");

        // 논리 연산자
        a = 10;
        System.out.println(5<a && a<15);                // true
        System.out.println((5<a && a<15) && a%2 == 0);  // true

        a = 4;
        System.out.println((5<a && a<15) && a%2 == 0);  // false
        System.out.println((5<a && a<15) || a%2 == 0);  // true
        System.out.println("\n");

        // 비트 연산자
        a = 15;
        b = 5;
        System.out.println(a|b);
        System.out.println(a&b);
        System.out.println(a^b);
        System.out.println(~a);

        System.out.println(a>>2);
        System.out.println(b<<4);
        System.out.println(b>>>2);
        System.out.println(a);      // a,b에는 여전히 값을 대입하지 않았다!!
        System.out.println(b);      // a,b에는 여전히 값을 대입하지 않았다!!
        System.out.println("\n");

        // 삼항 연산자
        int age = 17;
        System.out.println( age > 19 ? "성인입니다." : "성인이 아닙니다.");

        a += 1;
        System.out.println(a);



        a -= 2;
        System.out.println(a);

        a *= 2;
        System.out.println(a);

        a /= 2;
        System.out.println(a);

        a %= 5;
        System.out.println(a);
        System.out.println("\n");

        A obj_a = new A();
        B obj_b = new B();

        System.out.println("a instanceof A:" + (obj_a instanceof A));
        System.out.println("a instanceof A:" + (obj_b instanceof A));
        System.out.println("a instanceof A:" + (obj_a instanceof B));
        System.out.println("a instanceof A:" + (obj_b instanceof B));
    }
}
