package scoreusingbound;

import java.util.Scanner;

public class ScoreUsingBound {

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Subscriber pain = new Subscriber();
        Subscriber konan = new Subscriber();
        ScoreEvent scoreevent = new ScoreEvent();
        
        scoreevent.addPropertyChangeListener(pain);
        scoreevent.addPropertyChangeListener(konan);

        String line;
        do
        {
            System.out.print("Enter Score ");
            line = in.nextLine();
            if(line.length() > 0)
            {
                scoreevent.setScoreLine(line);
            }
        } 
        while(line.length() > 0);
    }
    
}
