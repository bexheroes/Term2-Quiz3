
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File f = new File(args[0]);
        football fb_list[] = new football[100];
        basketball bb_list[] = new basketball[100];
        voleyball vb_list[] = new voleyball[100];
        int count_fb = 0,count_bb = 0 ,count_vb = 0 , respond;
        int Score1,Score2;
        
        try{
            Scanner s = new Scanner(f);
            while(s.hasNextLine()){
                String line = s.nextLine();
                String splited_line[] = line.split("\t");
                if(splited_line[0].toUpperCase().equals("F")){
                    respond = inFootball(fb_list, count_fb, splited_line[1]);
                    if(respond == 0)
                        count_fb++;
                    respond = inFootball(fb_list, count_fb, splited_line[2]);
                    if(respond == 0)
                        count_fb++;
                    
                    String splited_splited_line[] = splited_line[3].split(":");
                    Score1 = Integer.parseInt(splited_splited_line[0].trim());
                    Score2 = Integer.parseInt(splited_splited_line[1].trim());
                    scoreFootball(fb_list[getSports(fb_list, count_fb, splited_line[1])], fb_list[getSports(fb_list, count_fb, splited_line[2])], Score1, Score2);
                  
                }else if(splited_line[0].toUpperCase().equals("B")){
                    respond = inBasketball(bb_list, count_bb, splited_line[1]);
                    if(respond == 0)
                        count_bb++;
                    respond = inBasketball(bb_list, count_bb, splited_line[2]);
                    if(respond == 0)
                        count_bb++;
                    
                    String splited_splited_line[] = splited_line[3].split(":");
                    Score1 = Integer.parseInt(splited_splited_line[0].trim());
                    Score2 = Integer.parseInt(splited_splited_line[1].trim());
                    scoreBasketball(bb_list[getSports(bb_list, count_bb, splited_line[1])], bb_list[getSports(bb_list, count_bb, splited_line[2])], Score1, Score2);
                  
                }else if(splited_line[0].toUpperCase().equals("V")){
                    respond = inVoleyball(vb_list, count_vb, splited_line[1]);
                    if(respond == 0)
                        count_vb++;
                    respond = inVoleyball(vb_list, count_vb, splited_line[2]);
                    if(respond == 0)
                        count_vb++;
                    
                    String splited_splited_line[] = splited_line[3].split(":");
                    Score1 = Integer.parseInt(splited_splited_line[0].trim());
                    Score2 = Integer.parseInt(splited_splited_line[1].trim());
                    scoreVoleyball(vb_list[getSports(vb_list, count_vb, splited_line[1])], vb_list[getSports(vb_list, count_vb, splited_line[2])], Score1, Score2);
                  
                }else{
                    System.out.println("Oops! "+splited_line[0]+" is not defined"); 
               }
            }
            for(int i=0;i<count_fb;i++){
                for(int j=0;j<count_fb;j++){
                    fixSports(fb_list, count_fb, fb_list[i] , fb_list[j]);
                }
            }
            for(int i=0;i<count_bb;i++){
                for(int j=0;j<count_bb;j++){
                    fixSports(bb_list, count_bb, bb_list[i] , bb_list[j]);
                }
            }
            for(int i=0;i<count_vb;i++){
                for(int j=0;j<count_vb;j++){
                    fixSports(vb_list, count_vb, vb_list[i] , vb_list[j]);
                }
            }
            printFootball(fb_list, count_fb,args[1]);
            printBaskeball(bb_list, count_bb,args[2]);
            printVoleyball(vb_list, count_vb,args[3]);
            
        }catch(FileNotFoundException e){
            System.out.println("Fixture File Cannot Found");
        }
        
    }
    public static int inFootball(football Arr[],int len,String Team){
        for(int i = 0 ; i < len ; i++){
            if(Arr[i].get_teamName().equals(Team)){
                return 1;
            }
        }
        football instance = new football("F", Team);
        Arr[len] = instance;
        return 0;
    }
    public static int inBasketball(basketball Arr[],int len,String Team){
        for(int i = 0 ; i < len ; i++){
            if(Arr[i].get_teamName().equals(Team)){
                return 1;
            }
        }
        basketball instance = new basketball("B", Team);
        Arr[len] = instance;
        return 0;
    }
    public static int inVoleyball(voleyball Arr[],int len,String Team){
        for(int i = 0 ; i < len ; i++){
            if(Arr[i].get_teamName().equals(Team)){
                return 1;
            }
        }
        voleyball instance = new voleyball("V", Team);
        Arr[len] = instance;
        return 0;
    }
    public static int getSports(sports Arr[],int len,String Team){
        for(int i = 0 ; i < len ; i++){
            if(Arr[i].get_teamName().equals(Team)){
                return i;
            }
        }
        return -1;
    }
    public static void scoreFootball(football Arr1,football Arr2,int score1,int score2){
        if(score1>score2){
            Arr1.win(score1, score2);
            Arr2.lose(score2, score1);
        }else if(score2>score1){
            Arr1.lose(score1, score2);
            Arr2.win(score2, score1);
        }else{
            Arr1.draw(score1, score2);
            Arr2.draw(score2, score1);
        }
    }
    public static void scoreBasketball(basketball Arr1,basketball Arr2,int score1,int score2){
        if(score1>score2){
            Arr1.win(score1, score2);
            Arr2.lose(score2, score1);
        }else{
            Arr1.lose(score1,score2);
            Arr2.win(score2, score1);
        }
    }
    public static void scoreVoleyball(voleyball Arr1,voleyball Arr2,int score1,int score2){
        if((score1 == 3) && (score2 == 1 || score2 == 0)){
            Arr1.win(score1, score2, 3);
            Arr2.lose(score2, score1, 0);
        }else if((score1 == 3) && (score2 == 2)){
            Arr1.win(score1, score2, 2);
            Arr2.lose(score2, score1, 1);
        }else if((score1 == 2) && (score2 == 3)){
            Arr1.lose(score1, score2, 1);
            Arr2.win(score2, score1, 2);
        }else if((score1 == 0 || score1 == 1) && (score2 == 3)){
            Arr1.lose(score1, score2, 0);
            Arr2.win(score2, score1, 3);
        }
    }
    public static void fixSports(sports ArrList[],int len,sports Arr1,sports Arr2){
        int index1,index2;
        index1 = getSports(ArrList, len, Arr1.get_teamName());
        index2 = getSports(ArrList, len, Arr2.get_teamName());
        if(Arr1.get_totalPoint()>Arr2.get_totalPoint()){
            if(index1>index2){
                ArrList[index2] = Arr1;
                ArrList[index1] = Arr2;
            }
        }else if(Arr2.get_totalPoint()>Arr1.get_totalPoint()){
            if(index2>index1){
                ArrList[index1] = Arr2;
                ArrList[index2] = Arr1;
            }
        }else{
            if(Arr1.get_average()>Arr2.get_average()){
                if(index1>index2){
                    ArrList[index2] = Arr1;
                    ArrList[index1] = Arr2;
                }
            }else{
                if(index2>index1){
                    ArrList[index1] = Arr2;
                    ArrList[index2] = Arr1;
                }
            }
        }
    }
    public static void printFootball(football Arr[],int len,String ff){
        try{
            File football_txt = new File(ff);
            BufferedWriter out = new BufferedWriter(new FileWriter(football_txt));
            for(int i=0;i<len;i++){
                int j = i+1;
                String string_toWrite = j+". \t"+Arr[i].get_teamName()+"\t"+Arr[i].gettotalMatch()+"\t"+Arr[i].getwinMatch()+"\t";
                string_toWrite+=Arr[i].gettieMatch()+"\t"+Arr[i].getloseMatch()+"\t"+Arr[i].getforPoints()+":"+Arr[i].getagainstPoints();
                string_toWrite+="\t"+Arr[i].get_totalPoint();
                if(i!=len-1){
                    string_toWrite+="\n";
                }
                out.write(string_toWrite);
            }
            out.close();
        }catch(Exception e){
            System.out.println("Football.out file cannot found/created");
        }
    }
    public static void printBaskeball(sports Arr[],int len,String ff){
        try{
            File basketball_txt = new File(ff);
            BufferedWriter out = new BufferedWriter(new FileWriter(basketball_txt));
            for(int i=0;i<len;i++){
                int j = i+1;
                String string_toWrite = j+". \t"+Arr[i].get_teamName()+"\t"+Arr[i].gettotalMatch()+"\t"+Arr[i].getwinMatch();
                string_toWrite+="\t"+Arr[i].getloseMatch()+"\t"+Arr[i].getforPoints()+":"+Arr[i].getagainstPoints();
                string_toWrite+="\t"+Arr[i].get_totalPoint();
                if(i!=len-1){
                    string_toWrite+="\n";
                }
                out.write(string_toWrite);
            }
            out.close();
        }catch(Exception e){
            System.out.println("Basketball.out file cannot found/created");
        }
    }
    public static void printVoleyball(sports Arr[],int len,String ff){
        try{
            File voleyball_txt = new File(ff);
            BufferedWriter out = new BufferedWriter(new FileWriter(voleyball_txt));
            for(int i=0;i<len;i++){
                int j = i+1;
                String string_toWrite = j+". \t"+Arr[i].get_teamName()+"\t"+Arr[i].gettotalMatch()+"\t"+Arr[i].getwinMatch();
                string_toWrite+="\t"+Arr[i].getloseMatch()+"\t"+Arr[i].getforPoints()+":"+Arr[i].getagainstPoints();
                string_toWrite+="\t"+Arr[i].get_totalPoint();
                if(i!=len-1){
                    string_toWrite+="\n";
                }
                out.write(string_toWrite);
            }
            out.close();
        }catch(Exception e){
            System.out.println("Voleyball.out file cannot found/created");
        }
    }
}
