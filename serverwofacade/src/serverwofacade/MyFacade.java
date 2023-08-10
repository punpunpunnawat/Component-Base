/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverwofacade;

/**
 *
 * @author Lenovo
 */
public class MyFacade {
    private static MyFacade myFacadeObj = null;
    private MyFacade(){}
    public static MyFacade getMyFacadeObject()
    {
        if(myFacadeObj == null)
        {
            myFacadeObj = new MyFacade();
        }
        return myFacadeObj;
    }
    
    public void startServer()
    {
        ScheduleServer scheduleServer = new ScheduleServer();
        scheduleServer.startBooting();
        scheduleServer.readSystemConfigFile();
        scheduleServer.init();
        scheduleServer.initializeContext();
        scheduleServer.initializeListeners();  
        scheduleServer.createSystemObjects(); 
        scheduleServer.createSystemObjects();
	System.out.println("Start working......");
    }
    
    public void stopServer()
    {
        System.out.println("After work done.........");
        ScheduleServer scheduleServer = new ScheduleServer();      
        scheduleServer.releaseProcesses();       
        scheduleServer.destory();        
        scheduleServer.destroySystemObjects();
        scheduleServer.destoryListeners();        
        scheduleServer.destoryContext();
        scheduleServer.shutdown();        
    }
}
