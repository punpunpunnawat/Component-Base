/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package football;

/**
 *
 * @author Lenovo
 */
public class Sasuke implements MyObserver{
    
    @Override
    public void update(Source o)
    {
        System.out.println("(Sasuke) headquater is updated to "+((HeadQuater)o).getScore());
    }
}
