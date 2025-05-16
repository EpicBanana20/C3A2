<%@page import="Modelo.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de Productos</h1>
        <% 
            ArrayList<Producto> productos = (ArrayList<Producto>)request.getAttribute("productos");
        %>
        <table border="1">
            <%
                for(Producto prod:productos){
            %>
            <tr valing="right">
                <td>
                    <%=prod.getClave()  %>                    
                </td>
                <td>
                    <%=prod.getNombre()  %>                    
                </td>
                <td>
                    <%=prod.getPrecio()  %>                    
                </td>
                <td>
                    <%=prod.getCantidad() %>                    
                </td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>
