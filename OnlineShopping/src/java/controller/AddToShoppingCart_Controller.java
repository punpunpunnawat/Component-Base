package controller;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Calculator;
import model.Products;

public class AddToShoppingCart_Controller extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String[] checkbArray = request.getParameterValues("CBDVDName");
        List<Products> pdList = ProductTable.findAllProduct();
        int unit, unitPrice = 0, totalPrice = 0;
        for(String MVname : checkbArray){  // call all Movie name    
            for(Products pd : pdList){  
                if(MVname.trim().equals(pd.getMovie()) && !request.getParameter(MVname.trim()).equals("")){ 
                    unit = Integer.parseInt(request.getParameter(MVname.trim())); // Call unit from Text Input
                    request.setAttribute(MVname.trim() + "_Quantity", unit);
                    unitPrice = Calculator.unitCalculator( pd.getPrice(), unit);
                    totalPrice = Calculator.totalCalculator(totalPrice, unitPrice); // Total price 
                    request.setAttribute(MVname.trim() + "_unitPrice", unitPrice);
                }
            }
        }
        request.setAttribute("totalPrice", totalPrice);
        HttpSession session = request.getSession();
        
        //remove old session attr
        Enumeration<String> sessionAttrList = session.getAttributeNames();
        while (sessionAttrList.hasMoreElements())
        {
            String singleAttr = sessionAttrList.nextElement();
            if(!singleAttr.contains("WELD_S_HASH"))
            {
                session.removeAttribute(singleAttr);
            }
        }
        
        Enumeration<String> attrList = request.getAttributeNames();
        while (attrList.hasMoreElements())
        {
            String singleAttr = attrList.nextElement();
            if(singleAttr.contains("_Quantity"))
            {
                session.setAttribute(singleAttr.replace("_Quantity", ""), request.getAttribute(singleAttr));
            }
        }
        
        request.getRequestDispatcher("AddToShoppingCart.jsp").forward(request, response);
    } 
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
