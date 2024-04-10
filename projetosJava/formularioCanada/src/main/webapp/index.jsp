<%@ page import="java.util.Map" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    Map<String, String> errors = (Map<String, String>) request.getAttribute("errors_map");
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Formulario</title>
    </head>
    <style>
        .error {
            color: #ff454a;
            font-size: 14px;
        }
    </style>
    <body>
        <form method="GET" action="<%= request.getContextPath()%>/form-validation">
            <label>
                Nome
                <input type="text" name="name">
                <br>
                <p class="error"><% if (errors != null && errors.containsKey("name_error")) {out.print(errors.get("name_error"));}%></p>
            </label>
            <br>
            <label>
                Data de nascimento
                <input type="date" name="birthdate">
                <br>
                <p class="error"><% if (errors != null && errors.containsKey("birthdate_error")) {out.print(errors.get("birthdate_error"));}%></p>
            </label>
            <br>
            <label>
                Idioma nativo
                <select name="language">
                    <option value="eng">Inglês</option>
                    <option value="sp">Espanhol</option>
                    <option value="ptbr">Português</option>
                </select>
                <br>
                <p class="error"><% if (errors != null && errors.containsKey("language_error")) {out.print(errors.get("language_error"));}%></p>
            </label>
            <br>
            <label>
                Habilidades técnicas
            </label>
            <br>
            <label>
                <input name="abilities" type="checkbox" value="java">Java
            </label>
            <label>
                <input name="abilities" type="checkbox" value="js">JavaScript
            </label>
            <label>
                <input name="abilities" type="checkbox" value="html">HTML
            </label>
            <label>
                <input name="abilities" type="checkbox" value="css">CSS
            </label>
            <br>
            <p class="error"><% if (errors != null && errors.containsKey("abilities_error")) {out.print(errors.get("abilities_error"));}%></p>
            <br>
            <label>
                Informações adicionais
                <br>
                <textarea name="extraInfo" placeholder="Inserir texto aqui..."></textarea>
                <br>
                <p class="error"><% if (errors != null && errors.containsKey("extraInfo_error")) {out.print(errors.get("extraInfo_error"));}%></p>
            </label>
            <br>
            <button type="submit">Enviar! :D</button>
        </form>
    </body>
</html>