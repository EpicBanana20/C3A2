package Control;

import Modelo.GestorBD;
import Modelo.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@WebServlet(name = "MuestraProductos", urlPatterns = {"/MuestraProductos"})
public class MuestraProductos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            ArrayList<Producto> lista = new ArrayList<>();
            Producto prod;
            GestorBD gestor = new GestorBD();
            lista = gestor.leerTodos();
            if (lista != null) {
                request.setAttribute("productos", lista);
                request.getRequestDispatcher("/listaProductos.jsp").forward(request, response);
            }
            else 
                request.getRequestDispatcher("/noHayRegistros.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
