<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <form method="POST">
      <h1>Age Calculator</h1>
      <p>
        <label for="age">Enter your age:</label>
        <input id="age" name="age" type="number" step="any" value="${age}" autofocus>
      </p>
      <p><input type="submit" value="Age next birthday"></p>
      <p>${response}</p>
      <p><a href="arithmetic">Arithmetic Calculator</a></p>
    </form>
  </body>
</html>