package Chapter_05;

public interface LottoMgrInterface {
    public void GenerateNumbers();  // 자동
    public void SetNumber(short[] arrNumbers);  // 수동

    public byte ConfirmNumbers(short[] arrSrcNumbers, short[] arrCnfNumbers);

}
