package headquaterusingbound;

public class HeadQuaterUsingBound
{
    public static void main(String[] args) 
    {
        HeadQuater headquater = new HeadQuater();
        Senior senior = new Senior();
        Marketing marketing = new Marketing();
        headquater.addPropertyChangeListener(senior);
        headquater.addPropertyChangeListener(marketing);
        headquater.setSomeData(6);
    }
}
