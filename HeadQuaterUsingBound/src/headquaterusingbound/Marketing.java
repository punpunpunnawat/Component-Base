package headquaterusingbound;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Marketing implements PropertyChangeListener
{
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("(marketing) headquater is updated to " + evt.getNewValue());
    }
    
}
