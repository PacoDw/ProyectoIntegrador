
package Servelets;

import Controlador.ControladorTicket;
import include.Ticket;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PacoD
 */
public class getTicket extends HttpServlet
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
        try (PrintWriter out = response.getWriter())
        {
            int id = Integer.parseInt(request.getParameter("codigo_referencia"));
            
            ControladorTicket ct = new ControladorTicket(); 

            Ticket t = ct.getATicketFull(id);
            
            if(!t.getId_ticket().equals("") || t.getId_ticket() != null)
            {
                     /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html><!DOCTYPE html>\n" +
"<html lang=\"es\">\n" +
"\n" +
"<head>\n" +
"    <meta charset=\"UTF-8\">\n" +
"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
"    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n" +
"    <script src=\"JS/jquery-3.2.1.min.js\"></script>\n" +
"    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js\"></script>    \n" +
"    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n" +
"    <link rel=\"stylesheet\" href=\"CSS/style_getTicket_page.css\">\n" +
"    <link rel=\"stylesheet\" href=\"CSS/style_header.css\">\n" +
"    <link rel=\"stylesheet\" href=\"CSS/style_footer.css\">\n" +
"    <link rel=\"stylesheet\" href=\"CSS/style_button.css\">\n" +
"    <link rel=\"stylesheet\" href=\"CSS/style_link.css\">\n" +
"    <title>Panel Administracion</title>\n" +
"    <title>Document</title>\n" +
"</head>\n" +
"\n" +
"<body>\n" +
"    <nav class=\"header\">\n" +
"        <h1 class=\"header-h1\">Help Desk</h1>\n" +
"        <ul class=\"nav-ul-cerrar-sesion\">\n" +
"            <li class=\"nav-li\">\n" +
"            </li>\n" +
"        </ul>\n" +
"    </nav>\n" +
"\n" +
"    <div class=\"div-resultado\">\n" +
"        <form class=\"form_mod\" id=\"form_valTicket\" action=\"\" method=\"post\" enctype=\"\">\n" +
"            <table class=\"table-formulario\">\n" +
"                <thead>\n" +
"                    <tr>\n" +
"                        <th class=\"td-formulario\" colspan=\"2\">\n" +
"                            <legend class=\"form-legend\">Datos del ticket</legend>\n" +
"                        </th>\n" +
"                    </tr>\n" +
"                </thead>\n" +
"                <tbody>\n" +
"                    <tr>\n" +
"                        <td class=\"td-formulario\">\n" +
"                            <label class=\"form-label\" for=\"idTicketMod\" rowspan=\"2\">Id del ticket:</label>\n" +
"                            <input class=\"form-input-reporte\" id=\"idTicketMod\" type=\"text\" name=\"idTicketMod\" placeholder=\"\" autocomplete=\"off\" autofocus\n" +
"                                maxlength=\"25\" required readonly value="+t.getId_ticket() +" >\n" + 
"\n" +
"                            <label class=\"form-label\" for=\"nombreTicketMod\" rowspan=\"2\">Nombre del ticket:</label>\n" +
"                            <input class=\"form-input-reporte\" id=\"nombreTicketMod\" type=\"text\" name=\"nombreTicketMod\" placeholder=\"\" autocomplete=\"off\"\n" +
"                                autofocus maxlength=\"25\" required value="+t.getNombre_ticket() + ">\n  " +
"\n" +
"                            <label class=\"form-label\" for=\"estadoMod\">Estado del ticket:</label>\n" +
"                            <select name=\"estadoMod\" id=\"estadoMod\" class=\"form-input-reporte\">\n" +
"                                <option value=\"Cerrado\">"+t.getEstado() +"</option>\n" +
"                            </select>\n" +
"\n" +
"                            <label class=\"form-label\" for=\"fecha_inicioMod\">Fecha de inicio de la reparación</label>\n" +
"                            <input class=\"form-input-reporte\" id=\"fecha_inicioMod\" type=\"text\" name=\"fecha_inicioMod\" placeholder=\"\" maxlength=\"25\"\n" +
"                                required readonly value="+t.getFecha_inicio() +">\n " +
"\n" +
"                            <label class=\"form-label\" for=\"fecha_aproxMod\">Fecha aproximada de reparación</label>\n" +
"                            <input class=\"form-input-reporte\" id=\"fecha_aproxMod\" type=\"text\" name=\"fecha_aproxMod\" placeholder=\"\" maxlength=\"25\"\n" +
"                                required value="+t.getFecha_aprox() +">\n " +
"\n" +
"                            <label class=\"form-label\" for=\"fecha_cierreMod\">Fecha de cierre de reparación</label>\n" +
"                            <input class=\"form-input-reporte\" id=\"fecha_cierreMod\" type=\"text\" name=\"fecha_cierreMod\" placeholder=\"\" maxlength=\"25\"\n" +
"                                required value="+t.getFecha_cierre() +">\n " +
"\n" +
"\n" +
"                        </td>\n" +
"                        <td class=\"td-formulario\">\n" +
"                            <label class=\"form-label\" for=\"grupo_especialistaMod\">Área encargada:</label>\n" +
"                            <select name=\"grupo_especialistaMod\" id=\"grupo_especialistaMod\" class=\"form-input-reporte\" required style=\"margin: 0 0 22px 0\">\n" +
"                                <option value=\"\" disabled selected>"+t.getGrupo_especialista() +"</option>\n" +
"                            </select>\n" +
"                            <label class=\"form-label\" for=\"especialistaMod\">Especialista:</label>\n" +
"                            <select name=\"especialistaMod\" id=\"especialistaMod\" class=\"form-input-reporte\" required style=\"margin: 0 0 22px 0\">\n" +
"                                <option value=\"\" disabled selected>"+t.getUsuario()+"</option>\n" +
"                            </select>\n" +
"\n" +
"                            <label class=\"form-label\" for=\"solucionMod\">Solución:</label>\n" +
"                            <textarea class=\"form-input-reporte\" name=\"solucionMod\" id=\"solucionMod\" cols=\"20\" rows=\"10\" placeholder=\"\" maxlength=\"1000\"\n" +
"                                style=\"height:88px; margin: 0 0 22px 0\" required>"+t.getSolucion() +"</textarea>\n" +
"\n" +
"                            <label class=\"form-label\" for=\"descripcionMod\">Descripción</label>\n" +
"                            <textarea class=\"form-input-reporte\" name=\"descripcionMod\" id=\"descripcionMod\" required cols=\"20\" rows=\"10\" placeholder=\"\"\n" +
"                                maxlength=\"1000\" style=\"height:88px; margin: 0 0 22px 0\" required>"+t.getDescripcion()+"</textarea>\n" +
"                            <label class=\"form-label\" for=\"comentariosMod\">Comentarios:</label>\n" +
"                            <textarea class=\"form-input-reporte\" name=\"comentariosMod\" id=\"comentariosMod\" cols=\"20\" rows=\"10\" placeholder=\"\" maxlength=\"250\"\n" +
"                                style=\"height:88px; margin: 0 0 22px 0\" required>"+t.getComentarios() +"</textarea>\n" +
"                        </td>\n" +
"                </tbody>\n" +
"            </table>\n" +
"        </form>\n" +
"    </div>\n" +
"    <script type=\"text/javascript\" src=\"JS/getTicket.js\"></script>\n" +
"</body>\n" +
"\n" +
"</html>");
            }
            else
                response.getWriter().write("0");
       
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
