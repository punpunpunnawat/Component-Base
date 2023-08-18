package headquaterusingevent;

public class HeadQuaterUsingEvent
{
    public static void main(String[] args)
    {
        Source source = new Source();
        Senior senior = new Senior();
        Marketing marketing = new Marketing();
        source.addObserver(senior);
        source.addObserver(marketing);
        source.setSomeData(5);
        source.setSomeData(7);
    }
}
