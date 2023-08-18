package headquaterusingevent;

import java.util.EventListener;

public interface MyObserver extends EventListener
{
    public void update(HeadQuaterEvent evt);
}
