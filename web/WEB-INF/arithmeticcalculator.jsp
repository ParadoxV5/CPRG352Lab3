<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Arithmetic Calculator</h1>
    <form method="POST">
      <p>
        <label for="first">First:</label>
        <input id="first" name="first" type="number" step="any" value="${first}" autofocus>
      </p>
      <p>
        <label for="second">Second:</label>
        <input id="second" name="second" type="number" step="any" value="${second}">
      </p>
      <p>
        <input type="submit" name="operator" value="+">
        <input type="submit" name="operator" value="-">
        <input type="submit" name="operator" value="×">
        <!-- XXX: Where’s divide ‘/’ ? -->
        <input type="submit" name="operator" value="%">
      </p>
    </form>
    <p>Result: ${result}</p>
    <p><a href="age">Age Calculator</a></p>
  </body>
</html>