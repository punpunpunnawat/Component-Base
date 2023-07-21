
package foot;

import java.util.Scanner;


public class FootApp {

    private FootShape foot;
    
    public void getFootTypeFromUser(String foodType) {
        switch(foodType) {
            case "Ellipse":
                foot = new EllipseFoot();
                break;
          
            case "Rectangle":
                foot = new RectangleFoot();
                break;   
        }
    }

    public String drawFoot()
    {
        return foot.draw();
    }
    
    public static void main(String[] args)
    {
        FootApp app = new FootApp();
        Scanner inp = new Scanner(System.in);
        System.out.println("Please choose customer type 1. Ellipse, 2. Rectangle");
        int type = inp.nextInt();
        switch(type) {
            case 1:
                app.getFootTypeFromUser("Ellipse");
                break;
            case 2:
                app.getFootTypeFromUser("Rectangle");
                break; 
        }
        System.out.println(app.drawFoot());   
    }
}
