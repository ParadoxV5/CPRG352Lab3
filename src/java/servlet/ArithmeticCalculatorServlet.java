package servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ArithmeticCalculatorServlet extends jakarta.servlet.http.HttpServlet {
  protected void respond(Object result, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute("result", result);
    getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
  }
  @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    respond("---", request, response);
  }
  
  protected void respondInvalid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    respond("invalid", request, response);
  }
  @Override protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Load parameters
    String
      operator = request.getParameter("operator"),
      first = request.getParameter("first"),
      second = request.getParameter("second")
    ;
    request.setAttribute("first", first);
    request.setAttribute("second", second);
    
    // `null` check, blank check (`first` & `second) and length check (`operator`)
    if(first == null || second == null || first.trim().isEmpty() || second.trim().isEmpty() || operator == null || operator.length() != 1) {
      respondInvalid(request, response);
      return;
    }
    
    // Convert to `double` check
    double firstDouble, secondDouble;
    try {
      firstDouble = Double.parseDouble(first);
      secondDouble = Double.parseDouble(second);
    } catch(NumberFormatException __) {
      respondInvalid(request, response);
      return;
    }
    
    // Process
    switch(operator.charAt(0)) {
      case '+': respond(firstDouble + secondDouble, request, response); return;
      case '-': respond(firstDouble - secondDouble, request, response); return;
      case '×': respond(firstDouble * secondDouble, request, response); return;
      //XXX: Where’s divide ‘/’ ?
      case '%':
        // Yeet! Forgot about divide by 0
        if(secondDouble == 0) respondInvalid(request, response);
        else respond(firstDouble % secondDouble, request, response);
      return;
      default: respondInvalid(request, response);
    }
  }
}