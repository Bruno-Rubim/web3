<%@ page import="java.util.Map" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    Map<String, String> errors = (Map<String, String>) request.getAttribute("errors_map");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <style>
        .error{
            color: #ff454a;
            font-size: 14px;
        }
    </style>
</head>
<body style="width:100%; justify-content: right">
<h1>Login de usuário</h1>
<br/>
<form action="<%= request.getContextPath()%>/verify-login" method="post">
    <div class="error"><% if (errors != null && errors.containsKey("login_error")) {out.print("<br>" + errors.get("login_error"));}%></div>
    <label>
        Nome de usuário:
        <br>
        <input type="text" name="username">
        <br><div class="error"><% if (errors != null && errors.containsKey("username_error")) {out.print(errors.get("username_error"));}%></div>
    </label>
    <br>
    <label>
        Senha:
        <br>
        <input type="password" name="password">
        <br><div class="error"><% if (errors != null && errors.containsKey("password_error")) {out.print(errors.get("password_error"));}%></div>
    </label>
    <br>
    <br>
    <button type="submit">Fazer Login</button>
</form>
</body>
</html>