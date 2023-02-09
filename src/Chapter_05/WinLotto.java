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
        System.out.println("WinLotto 죽어요!!!");
    }

    public void ShowWinNumbers() {
        System.out.println( "😃 이번주 당첨 번호 😃");
        System.out.println( "👉 " + wins );
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
        System.out.println("나의 번호 : " + numbers);
        System.out.println("맞춘 번호 : " + mywins);

        String res = String.format("%d개 맞음", mywins.size());
        System.out.println( res );

        switch ( mywins.size() )
        {
            case 6:
                System.out.println("1등 당첨!!!"); break;
            case 5:
                System.out.println("2등 당첨!!!"); break;
            case 4:
                System.out.println("3등 당첨!!!"); break;
            case 3:
                System.out.println("4등 당첨!!!"); break;
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
        System.out.println("나의 번호 : " + numbers);
    }

    public void InputOneNumber() {
        System.out.println("InputOneNumber");
        byte num = 0;
        Scanner sc = new Scanner(System.in);
        do {
            if (sc.hasNext()) {
                System.out.println("1에서부터 45의 수를 입력하세요");
                num = Byte.parseByte(sc.next());
            }
        } while (num <= 0 || num > 45 );

        this.SetNumber(num);
        sc.close();
    }

    public void InputSixNumbers() {
        while( numbers.size() < WinLotto.NUM_COUNT ) {
            InputOneNumber();
        }
    }

    public void Clear() {
        numbers.clear();
    }
}
