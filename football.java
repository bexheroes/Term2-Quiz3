
public class football extends sports{
    private int tieMatch;
    public football(String sportCategory,String teamName){
        super(sportCategory,teamName);
        tieMatch = 0;
    }
    @Override
    public void win(int f,int a){
        totalMatch += 1;
        winMatch += 1;
        totalPoint += 3;
        forPoints += f;
        againstPoints += a;
    }
    @Override
    public void lose(int f,int a){
        totalMatch += 1;
        loseMatch += 1;
        forPoints += f;
        againstPoints += a;
    }
    public void draw(int f,int a){
        totalMatch += 1;
        tieMatch += 1;
        totalPoint += 1;
        forPoints += f;
        againstPoints += a;
    }
    public int gettieMatch(){
        return tieMatch;
    }
}
