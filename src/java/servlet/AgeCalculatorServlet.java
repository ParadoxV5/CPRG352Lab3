package servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AgeCalculatorServlet extends jakarta.servlet.http.HttpServlet {

  @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
  }
  @Override protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Load parameters
    String age = request.getParameter("age");
    request.setAttribute("age", age);
    
    // `null`/blank check
    if(age == null || age.trim().isEmpty()) {
      request.setAttribute("response", "You must give your current age.");
      // Reload page
      doGet(request, response);
      return;
    }
    
    // Convert to `double` check
    double ageDouble;
    try { ageDouble = Double.parseDouble(age); } catch(NumberFormatException __) {
      request.setAttribute("response", "You must enter a number.");
      // Reload
      doGet(request, response);
      return;
    }
    //XXX: Should also check negative numbers?
    
    // Process
    request.setAttribute("response", "Your age next birthday will be " + (Math.floor(ageDouble) + 1));
    doGet(request, response);
  }
}