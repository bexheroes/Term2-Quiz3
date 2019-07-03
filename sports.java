
public class sports {
    protected String sportCategory,teamName;
    protected int totalMatch,winMatch,loseMatch,totalPoint,forPoints,againstPoints;
    protected sports(String sportCategory,String teamName){
        this.sportCategory = sportCategory;
        this.teamName = teamName;
        totalMatch = 0;
        winMatch = 0;
        loseMatch = 0;
        totalPoint = 0;
        forPoints = 0;
        againstPoints = 0;
    }
    public String get_teamName(){
        return teamName;
    }
    public int get_totalPoint(){
        return totalPoint;
    }
    public int get_average(){
       return (forPoints - againstPoints); 
    }
    public int gettotalMatch(){
        return totalMatch;
    }
    public int getwinMatch(){
        return winMatch;
    }
    public int getloseMatch(){
        return loseMatch;
    }
    public void win(int f,int a){
        
    }
    public void lose(int f,int a){
        
    }
    public void win(int f,int a,int p){
        
    }
    public void lose(int f,int a,int p){
        
    }
    public int getforPoints(){
        return forPoints;
    }
    public int getagainstPoints(){
        return againstPoints;
    }
}
