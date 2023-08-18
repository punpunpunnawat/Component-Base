package headquaterusingevent;

public class Senior implements MyObserver
{

    @Override
    public void update(HeadQuaterEvent evt) {
        System.out.println("(senior) headquater is updated to " + evt.getSomeData());
    }
    
}
