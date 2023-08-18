package headquaterusingevent;

import java.util.ArrayList;

public class Source
{
    ArrayList<MyObserver> observers;
    
    public Source()
    {
        observers = new ArrayList<>();
    }
    
    public void addObserver(MyObserver obj)
    {
        observers.add(obj);
    }
    
    public void setSomeData(int value)
    {
        fireHeadQuaterEvent(new HeadQuaterEvent(this, value));
    }
    
    public void fireHeadQuaterEvent(HeadQuaterEvent evt)
    {
        for(MyObserver observer : observers)
        {
            observer.update(evt);
        }
    }
}
