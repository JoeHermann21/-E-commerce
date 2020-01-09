<%-- 
    Document   : erro
    Created on : 28/04/2019, 13:11:38
    Author     : andre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <h1>Erro!</h1>
        <%= ((Exception)request.getAttribute("erro")).getMessage() %>
    </body>
</html>
