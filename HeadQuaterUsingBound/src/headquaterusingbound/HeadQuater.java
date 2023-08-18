package headquaterusingbound;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class HeadQuater 
{
   
    private int someData;

    public static final String PROP_SOMEDATA = "someData";

    public int getSomeData()
    {
        return someData;
    }

    public void setSomeData(int someData)
    {
        int oldSomeData = this.someData;
        this.someData = someData;
        propertyChangeSupport.firePropertyChange(PROP_SOMEDATA, oldSomeData, someData);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener)
    {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener)
    {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

}
