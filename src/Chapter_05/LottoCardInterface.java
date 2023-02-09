package Chapter_05;


public interface LottoCardInterface {
    // 자동으로 번호 생성
    public void GenerateNumbers();  // 자동

    // 수동으로 한개씩 번호를 입력하여 내부적으로 총 6개의 숫자 완성
    public void SetNumber(byte number);  // 수동

    //
    public byte CheckWin(WinLotto wl);

}
