<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@page import="Control.Consulta" %>
        <h1>Pantalla Principal</h1>
        <form action="Consulta" method="post">
            <table border="1">
                <tr>
                    <td>Clave: </td>
                    <td>
                        <input type="text" name="clave">
                    </td>
                </tr>
                <tr>
                    <td>Nombre: </td>
                    <td>
                        <input type="text" name="nombre">
                    </td>
                </tr>                
            </table>
            <input type="reset" value="Borrar">
            <input type="submit" value="Consultar">
        </form>
    </body>
</html>
