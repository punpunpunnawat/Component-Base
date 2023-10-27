package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Products;
import model.Shoppingcart;

public class ShowConfirmation_Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        
        Enumeration<String> sessionAttrList = session.getAttributeNames();
        HashMap<String, Integer> sessionmap = new HashMap<>();
        while (sessionAttrList.hasMoreElements())
            {
                String singleAttr = sessionAttrList.nextElement();
                if(!singleAttr.contains("WELD_S_HASH"))
                {
                    sessionmap.put(singleAttr, (int)session.getAttribute(singleAttr));
                }
            }
        session.invalidate();
        
        synchronized(getServletContext())
        {
            int lastestCartID = ProductTable.findLastestCartID();
            getServletContext().setAttribute("lastestID", lastestCartID+1);
            
            for(String movie : sessionmap.keySet())
            {
                Products pd = ProductTable.findProductByMovie(movie);
                Shoppingcart shopCart = new Shoppingcart((int) getServletContext().getAttribute("lastestID"), pd.getId());
                shopCart.setQuantity(sessionmap.get(movie));
                ProductTable.insertShoppingCart(shopCart);
            }
            
            
        }
        request.setAttribute("totalPrice", request.getParameter("totalPrice"));
        request.getRequestDispatcher("ShowConfirmation.jsp").forward(request, response);
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
