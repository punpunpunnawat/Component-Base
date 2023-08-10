/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package football;

import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class HeadQuater implements Source{
    private final ArrayList<MyObserver> list;
    private String scoreLog;
    
    public HeadQuater()
    {
        this.list = new ArrayList<MyObserver>();
    }
    
    public void setScore(String log)
    {
        scoreLog = log;
        notifyObservers();
    }
    
    public String getScore()
    {
        return scoreLog;
    }
    
    @Override
    public void register(MyObserver observer)
    {
        list.add(observer);
    }
    
    @Override
    public void notifyObservers()
    {
        for(int i = 0 ; i < list.size(); i++)
        {
            list.get(i).update(this);
        }
    }
}
