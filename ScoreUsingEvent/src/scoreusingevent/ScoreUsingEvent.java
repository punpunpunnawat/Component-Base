package scoreusingevent;

import java.util.Scanner;

public class ScoreUsingEvent
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
   
        Subscriber juzo = new Subscriber();
        Subscriber itachi = new Subscriber();
        Subscriber kisame = new Subscriber();

        ScoreSource scoresource = new ScoreSource();
        
        scoresource.addObserver(juzo);
        scoresource.addObserver(itachi);
        scoresource.addObserver(kisame);
        
        scoresource.removeObserver(juzo);

        String line;
        do
        {
            System.out.print("Enter Score ");
            line = in.nextLine();
            if(line.length() > 0)
            {
                scoresource.setScoreLine(line);
            }
        } 
        while(line.length() > 0);
    }
}
