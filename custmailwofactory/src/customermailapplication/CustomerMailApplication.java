/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package customermailapplication;

import java.util.Scanner;

/**
 *
 * @author sarun
 */
public class CustomerMailApplication {

    /**
     * @param args the command line arguments
     */
    private static Customer customer;
    
    public String generateMail() {
        return customer.createMail();
    }
    
    public static void main(String[] args) {
        CustomerMailApplication app = new CustomerMailApplication();
        Scanner inp = new Scanner(System.in);
        System.out.print("Please choose customer type 1. Regular, 2. Mountain, 3. Delinquent ");
        int type = inp.nextInt();
        switch(type) {
            case 1:
                customer = CustomerMailFactory.createCustomerTypeFromUser("");
                break;
            case 2:
                customer = CustomerMailFactory.createCustomerTypeFromUser("Mountain");
                break;
            case 3:
                customer = CustomerMailFactory.createCustomerTypeFromUser("Delinquent");
                break;
        }
        System.out.println(app.generateMail());        
    }
}
