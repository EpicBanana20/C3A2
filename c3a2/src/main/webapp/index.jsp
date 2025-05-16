<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@page import="Control.Registro, Control.MuestraProductos" %>
        <h1>Pantalla Principal</h1>
        <form action="Registro" method="post">
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
                <tr>
                    <td>Precio: </td>
                    <td>
                        <input type="text" name="precio">
                    </td>
                </tr>
                <tr>
                    <td>Cantidad: </td>
                    <td>
                        <input type="text" name="cantidad">
                    </td>
                </tr>
            </table>
            <input type="reset" value="Borrar">
            <input type="submit" value="Registrar">
        </form>
        <br>
        <form action="index_1.jsp" method="post">
            <input type="submit" value="Consultar Registro">
        </form>
        <br>
        <form action="MuestraProductos" method="post">
            <input type="submit" value="Lista de Productos">
        </form>
    </body>
</html>

