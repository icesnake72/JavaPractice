package Chapter_04;


import java.text.CollationElementIterator;
import java.text.SimpleDateFormat;
import java.util.*;

public class MyArray {
    public static void main(String[] args) {
//        SeqSorter ss = new SeqSorter();
//        ss.DoSort();
//
//        BubbleSorter bs = new BubbleSorter();
//        bs.DoSort();

        // 배열은 같은 타입으로만 선언이 가능합니다!!
        // int[] arrSorter = new int[3];

        // 위와 같은 한계를 객체 지향 프로그래밍의 다형성으로 해결 가능!!!
        Sorter[] arrSorter = new Sorter[6];
        for( int i=0; i<6; i++) {
            if ( (i+1)%2 == 1 )
                arrSorter[i] = new SeqSorter();
            else
                arrSorter[i] = new BubbleSorter();
        }

        System.out.println();
        System.out.println("6번의 소트 시작");
        System.out.println();

        int procTime = 0;
        for( Sorter sort : arrSorter ){
            sort.DoSort();
            System.out.println("처리 시간 : " + sort.GetProcTime() + "ms.");
            System.out.println();
        }

//        //System.out.print();
//        Calendar cal = Calendar.getInstance();
//        int y = cal.get(Calendar.YEAR);
//        int m = cal.get(Calendar.MONTH) + 1;
//        int d = cal.get(Calendar.DATE);
//        System.out.println(y + "-" + m + "-" + d);
//        System.out.println(cal.get(Calendar.DAY_OF_WEEK));
//        System.out.println(cal.get(Calendar.DAY_OF_YEAR));
//        System.out.println(cal.getActualMaximum(Calendar.DATE));
//
//        Calendar anniv = Calendar.getInstance();
//        anniv.set(Calendar.MONTH, 7);
//        anniv.set(Calendar.DATE, 12);
//        anniv.set(Calendar.YEAR, 2023);
//        long diff = anniv.getTimeInMillis() - cal.getTimeInMillis();
//        long dayMillis = 24 * 60 * 60 * 1000;
//        System.out.println( diff / dayMillis + "일");
//
//        Date now = cal.getTime();
//        System.out.println( now );
//
//        Date myDate = new Date();
//        String pat = "yyyy년 MM월 dd일 E요일, HH:mm:ss";
//        SimpleDateFormat korea = new SimpleDateFormat(pat);
//        System.out.println( korea.format(myDate) );
//
////        int a = 10;
////        int b = 0;
////        int c = a / b;
//
//        try
//        {
//            int a = 10;
//            int b = 0;
//            int c = a / b;
//        }
//        catch (Exception e)
//        {
//            System.out.println(e.getMessage());
//        }
//
//
//
//        System.out.println(arrSorter.length);
//
//        for(int i=0; i<10; i++)
//        {
//            try {
//                if ( arrSorter.length <= i ) {
//                    ArrayIndexOutOfBoundsException exc = new ArrayIndexOutOfBoundsException(i);
//                    throw (exc);
//                }
//            }
//            catch (ArrayIndexOutOfBoundsException e)
//            {
//                System.out.println(e.getMessage());
//            }
//            finally {
//                System.out.println("for loop는 계속된다!!!");
//            }
//        }

        // Set의 특징 : 순서없이 자료를 갖는다, 중복 데이터를 허용하지 않는다.

        HashSet hs = new HashSet(); // Generic 이 적용 안된 상태
        hs.add("스트링");
        hs.add(1);
        hs.add(3.14);
        hs.add(arrSorter[0]);
        hs.add(1);      // add해도 안들어감
        hs.add(3.14);   // add해도 안들어감

        Iterator it = hs.iterator();
        while ( it.hasNext() ) {
            System.out.println(it.next());
        }
        System.out.println( hs.size());

        TreeSet ts = new TreeSet<String>(); // Generic이 적용안된 TreeSet은 입력 불가
        ts.add("스트링");
        ts.add("1");
        ts.add("3.14");
        ts.add(arrSorter[0].toString());
        ts.add("1");
        ts.add("3.14");

        Iterator it2 = ts.iterator();
        while ( it2.hasNext() ) {
            System.out.println(it2.next());
        }
        System.out.println( ts.size());

        TreeSet ts2 = new TreeSet<String>();
        ts2.add("김은범");
        ts2.add("유재석");
        ts2.add("강호동");
        ts2.add("장동건");
        ts2.add("신동엽");
        it2 = ts2.iterator();
        while ( it2.hasNext() ) {
            System.out.println(it2.next());
        }
        System.out.println( ts2.size());
        System.out.println( ts2 );
        if ( ts2.contains("신동엽") )
            System.out.println("신동엽 있음");
        else
            System.out.println("신동엽 없음");

        if ( ts2.contains("현빈") )
            System.out.println("현빈 있음");
        else
            System.out.println("현빈 없음");

        ts2.remove("신동엽");
        ts2.add("현빈");
        System.out.println(ts2);


        Random rnd = new Random();
        ArrayList al1 = new ArrayList<Integer>();
        for(int i=0; i<10; i++)
            al1.add( Math.abs(rnd.nextInt())%100 + 1 );

        System.out.println( al1 );
        System.out.println( al1.size());

        al1.add(1, 5);
        System.out.println( al1 );
        System.out.println( al1.size());

        al1.remove(2);
        System.out.println( al1 );
        System.out.println( al1.size());

        Collections.sort(al1);
        System.out.println( al1 );
        System.out.println( al1.size());

        Collections.sort(al1, Collections.reverseOrder());
        System.out.println( al1 );
        System.out.println( al1.size());


        LinkedList ll2 = new LinkedList<String>();
        ll2.add("페라리");
        ll2.add("람보르기니");
        ll2.add("포르쉐");
        ll2.add("벤츠");
        ll2.add("BMW");
        ll2.add("제네시스");

        System.out.println( ll2 );
        System.out.println( ll2.size());

        ll2.add(2,"벤틀리");
        System.out.println( ll2 );
        System.out.println( ll2.size());

        // indexOf() 와 get()
        int n = ll2.indexOf("BMW");
        System.out.println("BMW의 위치 : " + n);
        System.out.println(n + "번째 아이템 : " + ll2.get(n));
        ll2.set(n, "비엠더블유");
        System.out.println( ll2 );
        System.out.println( ll2.size());

        Collections.sort( ll2 );
        System.out.println( ll2 );

        HashMap hm = new HashMap();
        hm.put(1, "김은범");
        hm.put(2, "정우성");
        hm.put(3, "이정재");
        hm.put(4, "유재석");
        hm.put(5, "강호동");
        System.out.println( hm );

        hm.put(3, "이병헌");
        System.out.println( hm );

        hm.put(3.5, "신동엽");
        System.out.println( hm );

        hm.put(0, "김종국");
        System.out.println( hm );

        hm.put(-1, "지석진");
        System.out.println( hm );

        hm.put(9, "송지효");
        System.out.println( hm );

        hm.put(7, "이광수");
        System.out.println( hm );

        hm.put(-3, "오달수");
        System.out.println( hm );
    }
}
