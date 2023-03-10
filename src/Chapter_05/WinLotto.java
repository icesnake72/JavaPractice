package Chapter_05;

import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class WinLotto {
    protected static final byte NUM_COUNT = 6;

    protected LinkedList<Byte> wins;
    public WinLotto() {
        wins = new LinkedList<>();
        WinLotto.GenerateRandomNumbers(wins);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("WinLotto ì£½ì´ì!!!");
    }

    public void ShowWinNumbers() {
        System.out.println( "ð ì´ë²ì£¼ ë¹ì²¨ ë²í¸ ð");
        System.out.println( "ð " + wins );
    }

    public static void GenerateRandomNumbers(@NotNull LinkedList<Byte> numbers) {
        numbers.clear();
        int tmp;
        while ( numbers.size() < WinLotto.NUM_COUNT) {
            tmp = ((int)((Math.random() * 1000) % 45)) + 1;
            if ( numbers.contains((byte)tmp))
                continue;

            numbers.add((byte)tmp);
        }

        Collections.sort(numbers);
    }
}

class LottoCard implements LottoCardInterface {
    LinkedList<Byte> numbers;
    LinkedList<Byte> mywins;

    public LottoCard() {
        numbers = new LinkedList<>();
        mywins = new LinkedList<>();
        this.GenerateNumbers();
    }

    @Override
    public void GenerateNumbers() {
        numbers.clear();
        WinLotto.GenerateRandomNumbers(numbers);
    }

    @Override
    public void SetNumber(byte number) {}

    @Override
    public byte CheckWin(@NotNull WinLotto wl) {
        mywins.clear();
        for(Byte num : numbers) {
            for(Byte win : wl.wins) {
                if ( num==win )
                    mywins.add(num);
            }
        }
        System.out.println("ëì ë²í¸ : " + numbers);
        System.out.println("ë§ì¶ ë²í¸ : " + mywins);

        String res = String.format("%dê° ë§ì", mywins.size());
        System.out.println( res );

        switch ( mywins.size() )
        {
            case 6:
                System.out.println("1ë± ë¹ì²¨!!!"); break;
            case 5:
                System.out.println("2ë± ë¹ì²¨!!!"); break;
            case 4:
                System.out.println("3ë± ë¹ì²¨!!!"); break;
            case 3:
                System.out.println("4ë± ë¹ì²¨!!!"); break;
            default:
        }

        return (byte)mywins.size();
    }
}


class LottoCardEx extends LottoCard implements LottoCardInterface {
    @Override
    public void SetNumber(byte number) {
        if ( number <= 0 || number > 45 )
            return;

        if ( numbers.size() >= WinLotto.NUM_COUNT )
            return;

        if ( !numbers.contains(number) )
            numbers.add((byte)number);

        Collections.sort(numbers);
        System.out.println("ëì ë²í¸ : " + numbers);
    }

    public void InputOneNumber(@NotNull Scanner sc) {
        System.out.println("InputOneNumber");
        byte num = 0;

        do {

            if (sc.hasNext()) {
            System.out.println("1ììë¶í° 45ì ìë¥¼ ìë ¥íì¸ì");
            num = sc.nextByte();
            // num = Byte.parseByte(sc.next());
            }

        } while (num <= 0 || num > 45 );

        this.SetNumber(num);

    }

    public void InputSixNumbers() {
        Scanner sc = new Scanner(System.in);
        while( numbers.size() < WinLotto.NUM_COUNT ) {

            InputOneNumber(sc);

        }
        sc.close();
    }

    public void Clear() {
        numbers.clear();
    }
}
