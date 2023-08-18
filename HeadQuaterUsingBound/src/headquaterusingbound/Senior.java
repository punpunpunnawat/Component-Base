package headquaterusingbound;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Senior implements PropertyChangeListener
{
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("(senior) headquater is updated to " + evt.getNewValue());
    }
    
}
