/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets;

import Controlador.ControladorGrupoEspecialista;
import Controlador.ControladorTicket;
import Controlador.ControladorUsuario;
import com.google.gson.Gson;
import include.GrupoEspecialista;
import include.Ticket;
import include.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PacoDw
 */
public class CrudTicket extends HttpServlet
{

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");

        String metodo = request.getParameter("metodo");

        ControladorTicket ct = new ControladorTicket();

        if (metodo == "create")
        {

        }
        else if (metodo == "update")
        {

        }
        else if (metodo.equals("delete"))
        {
            int id = Integer.parseInt(request.getParameter("id_ticket"));
            if (ct.deleteTicket(id))
            {
                response.getWriter().write("True");
            }
            else
            {
                response.getWriter().write("False");
            }
        }
        else if (metodo.equals("getGrupos"))
        {
            ControladorGrupoEspecialista cge = new ControladorGrupoEspecialista();
            List<GrupoEspecialista> grupos = cge.getALLGrupos();

            String json = new Gson().toJson(grupos);

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        }
        else if (metodo.equals("getUsuarios"))
        {
            int id = Integer.parseInt(request.getParameter("optionId"));
            ControladorUsuario cu = new ControladorUsuario();
            List<Usuario> usuarios = cu.getUsuariosGrupos(id);
            
            String json = new Gson().toJson(usuarios);

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        }
        else
        {
            response.getWriter().write("");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
