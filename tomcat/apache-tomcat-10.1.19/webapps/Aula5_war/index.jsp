<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>

<%
//    String erro_texto = (String) request.ge
%>

<h1>Formulario Teste</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>



<form action="<%= request.getContextPath()%>/hello-servlet" method="GET">

    <input type="text" name="field_text" placeholder="Loren ipidasda" >
    <input type="number" name="field_number" placeholder="123">
    <input type="date" name="field_date"><br>

    <input type="radio" name="field_radioOption" value="a">"A"<br>
    <input type="radio" name="field_radioOption" value="b">"B"<br>
    <input type="radio" name="field_radioOption" value="c">"C"<br>


    <input type="checkbox" name="field_checkboxOption" value="Coringa"> Coringa<br>
    <input type="checkbox" name="field_checkboxOption" value="Batman"> Batman<br>
    <input type="checkbox" name="field_checkboxOption" value="Hulk"> Hulk<br>




    <button type="submit">Enviar</button>



</form>
</body>
</html>