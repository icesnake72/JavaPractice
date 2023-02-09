package Chapter_05;

import java.util.LinkedList;

public class LottoSimulator {

    public static void main(String[] args) {
        WinLotto winLotto = new WinLotto();
        winLotto.ShowWinNumbers();

        System.out.println();
        System.out.println("자동 번호 100개 생성");

        int nCount = 0;
        byte ret;
        LottoCard myLotto = new LottoCard();
        for (int i = 0; i < 100; i++) {
            ret = myLotto.CheckWin(winLotto);
            if ( ret >= 3) ++nCount;

            System.out.println();
            myLotto.GenerateNumbers();
        }

        if ( nCount > 0 ) {
            System.out.println(String.format("3등이상 당첨 확률 : %d%%", nCount));
        }


        LottoCardEx myLottoEx = new LottoCardEx();
        myLottoEx.Clear();
        myLottoEx.InputSixNumbers();
        myLottoEx.CheckWin(winLotto);
    }
}
