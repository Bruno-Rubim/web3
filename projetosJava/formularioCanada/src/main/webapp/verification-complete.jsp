<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Verificação completa</title>
    </head>
    <body>
        <p>Nome: ${requestScope.curriculo.name}</p>
        <p>Data de nascimento: ${requestScope.curriculo.birthdate}</p>
        <p>Língua nativa: ${requestScope.curriculo.language}</p>
        <p>Abilidades: ${requestScope.curriculo.abilities}</p>
        <p>Iformações adicionais: ${requestScope.curriculo.extraInfo}</p>
    </body>
</html>
