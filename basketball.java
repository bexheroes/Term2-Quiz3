
public class basketball extends sports{
    public basketball(String sportsCategory,String teamName){
        super(sportsCategory,teamName);
    }
    @Override
    public void win(int f,int a){
        totalMatch += 1;
        winMatch += 1;
        totalPoint += 2;
        forPoints += f;
        againstPoints += a;
    }
    @Override
    public void lose(int f,int a){
        totalMatch += 1;
        loseMatch += 1;
        totalPoint += 1;
        forPoints += f;
        againstPoints += a;
    }
}
