/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package football;
import java.util.Scanner;
/**
 *
 * @author Lenovo
 */
public class Football {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        Naruto naruto = new Naruto();
        Sasuke sasuke = new Sasuke();
        HeadQuater obj = new HeadQuater();
        obj.register(naruto);
        obj.register(sasuke);
        String line;
        do
        {
            System.out.print("Enter Score ");
            line = in.nextLine();
            if(line.length() > 0)
            {
                obj.setScore(line);   
            }
        } 
        while(line.length() > 0);
    }
    
}
