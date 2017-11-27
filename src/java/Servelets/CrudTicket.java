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
import com.google.gson.JsonArray;
import include.GrupoEspecialista;
import include.Ticket;
import include.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
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

        if (metodo.equals("create"))
        {
            Ticket t = new Ticket(request.getParameter("nombreTicket"), 
                                  request.getParameter("descripcion"), 
                                  request.getParameter("fecha_aprox"), 
                                  request.getParameter("comentarios"), 
                                  request.getParameter("grupo_especialista"), 
                                  request.getParameter("especialista"));
            
            if(ct.crearTicket(t))
            {
                t = ct.getLastTicket();
                String json = new Gson().toJson(t);

                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(json);
            }
            else
                request.getParameter(null);

        }
        else if (metodo.equals("update"))
        {
            Ticket t = new Ticket();
            String fechaCierre = request.getParameter("fecha_cierreMod");
            
            t.setId_ticket(request.getParameter("idTicketMod"));
            t.setNombre_ticket(request.getParameter("nombreTicketMod"));
            t.setDescripcion(request.getParameter("descripcionMod"));
            t.setEstado(request.getParameter("estadoMod"));
            t.setSolucion(request.getParameter("solucionMod"));
            t.setFecha_inicio(request.getParameter("fecha_inicioMod").replace("T", " "));
            t.setFecha_aprox(request.getParameter("fecha_aproxMod").replace("T", " "));
            
            if(fechaCierre == null || fechaCierre.equals(""))
            {
                Date d = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                t.setFecha_cierre(sdf.format(d));
                //t.setFecha_cierre("null");
            }
            else
                t.setFecha_cierre(request.getParameter("fecha_cierreMod").replace("T", " "));
            
            t.setComentarios(request.getParameter("comentariosMod"));
            t.setGrupo_especialista(request.getParameter("grupo_especialistaMod"));
            t.setUsuario(request.getParameter("especialistaMod"));
            
            if(ct.updateTicket(t)){
                t = ct.getATicket(Integer.parseInt(request.getParameter("idTicketMod")));
                String json = new Gson().toJson(t);

                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(json);
            }else
                request.getParameter(null);
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
        else if(metodo.equals("getATicket"))
        {
            int id = Integer.parseInt(request.getParameter("id_ticket"));
            
            Ticket t = ct.getATicketFull(id);
                
                String json = new Gson().toJson(t);

                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(json);
       
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
