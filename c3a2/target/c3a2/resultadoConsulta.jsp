<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@page import="Modelo.Producto" %>
        <h1>Registro Consultado</h1>
        
        <%
            Producto prod = (Producto)request.getAttribute("producto");
        %>
        
            <table border="1">
                <tr>
                    <td>Clave: </td>
                    <td>
                        <%=prod.getClave() %>
                    </td>
                </tr>
                <tr>
                    <td>Nombre: </td>
                    <td>
                        <%=prod.getNombre() %>
                    </td>
                </tr>
                <tr>
                    <td>Precio: </td>
                    <td>
                        <%=prod.getPrecio() %>
                    </td>
                </tr>
                <tr>
                    <td>Cantidad: </td>
                    <td>
                        <%=prod.getCantidad() %>
                    </td>
                </tr>
            </table>
        <form action="index_1.jsp" method="post">           
            <input type="submit" value="Regresar">
        </form>
    </body>
</html>
