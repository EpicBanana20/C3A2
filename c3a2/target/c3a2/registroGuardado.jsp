<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@page import="Modelo.Producto" %>
        <h1>Registro Guardado</h1>
        
        <%
            int cve = Integer.parseInt(request.getParameter("clave"));
            String nom = request.getParameter("nombre");
            double prec = Double.parseDouble(request.getParameter("precio"));
            int cant = Integer.parseInt(request.getParameter("cantidad"));
        %>
        
            <table border="1">
                <tr>
                    <td>Clave: </td>
                    <td>
                        <%=cve %>
                    </td>
                </tr>
                <tr>
                    <td>Nombre: </td>
                    <td>
                        <%=nom %>
                    </td>
                </tr>
                <tr>
                    <td>Precio: </td>
                    <td>
                        <%=prec %>
                    </td>
                </tr>
                <tr>
                    <td>Cantidad: </td>
                    <td>
                        <%=cant %>
                    </td>
                </tr>
            </table>
        <form action="index.jsp" method="post">           
            <input type="submit" value="Regresar">
        </form>
    </body>
</html>
