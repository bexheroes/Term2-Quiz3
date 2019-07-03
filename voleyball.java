
public class voleyball extends sports{
    public voleyball(String sportsCategory,String teamName){
        super(sportsCategory,teamName);
    }
    @Override
    public void win(int f,int a,int p){
        totalMatch += 1;
        winMatch += 1;
        totalPoint += p;
        forPoints += f;
        againstPoints += a;
    }
    @Override
    public void lose(int f,int a,int p){
        totalMatch += 1;
        loseMatch += 1;
        totalPoint += p;
        forPoints += f;
        againstPoints += a;
    }
}
