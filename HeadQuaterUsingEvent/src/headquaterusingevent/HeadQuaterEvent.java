package headquaterusingevent;

import java.util.EventObject;

public class HeadQuaterEvent extends EventObject
{
    private int someData;
    
    public int getSomeData()
    {
        return someData;
    }
    
    public HeadQuaterEvent(Object source, int value)
    {
        super(source);
        someData = value;
    }
    
}
