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

@WebServlet(name = "Consulta", urlPatterns = {"/Consulta"})
public class Consulta extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int cve = Integer.parseInt(request.getParameter("clave"));
            String nom = request.getParameter("nombre");
            Producto prod;
            GestorBD gestor = new GestorBD();
            prod = gestor.consulta(cve, nom);
            if (prod != null){
                request.setAttribute("producto", prod);
                request.getRequestDispatcher("/resultadoConsulta.jsp").forward(request, response);
            }
            else 
                request.getRequestDispatcher("/NoEncontrado.jsp").forward(request, response);
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

