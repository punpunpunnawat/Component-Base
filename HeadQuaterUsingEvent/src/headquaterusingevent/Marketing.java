package headquaterusingevent;

public class Marketing implements MyObserver
{

    @Override
    public void update(HeadQuaterEvent evt) {
        System.out.println("(marketing) headquater is updated to " + evt.getSomeData());
    }
    
}
