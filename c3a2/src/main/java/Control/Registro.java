package Control;

import Modelo.GestorBD;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "Registro", urlPatterns = {"/Registro"})
public class Registro extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int cve = Integer.parseInt(request.getParameter("clave"));
            String nom = request.getParameter("nombre");
            double prec = Double.parseDouble(request.getParameter("precio"));
            int cant = Integer.parseInt(request.getParameter("cantidad"));
            
            GestorBD gestor = new GestorBD();
            if (gestor.registrar(cve, nom, prec, cant)) {
                request.getRequestDispatcher("/registroGuardado.jsp").forward(request, response);
            }
            else 
                request.getRequestDispatcher("/ErrorDeRegistro.jsp").forward(request, response);         
        }
        finally {
            response.getWriter().close();
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

