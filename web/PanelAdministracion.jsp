<%-- 
    Document   : PanelAdministracion
    Created on : 14/11/2017, 10:02:04 PM
    Author     : PacoDw
--%>

    <%@page import="include.Usuario"%>
        <%@page import="Controlador.ControladorUsuario"%>
            <%@page contentType="text/html" pageEncoding="UTF-8"%>
                <%

    /*
HttpSession session=request.getSession(false);  
if(session!=null){  
String name=(String)session.getAttribute("name");  
          
out.print("Hello, "+name+" Welcome to Profile");  
}  
     */
    HttpSession sesion = request.getSession(true);

    Object username = sesion.getAttribute("username");

    if (username == null)
    {
        username = null;
    }
    else
    {
        username = sesion.getAttribute("username");
    }

    //session.invalidate(); 
%>
                    <html lang="es">

                    <head>
                        <meta charset="UTF-8">
                        <meta name="viewport" content="width=device-width, initial-scale=1.0">
                        <meta http-equiv="X-UA-Compatible" content="ie=edge">
                        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
                        <script src="JS/jquery-3.2.1.min.js"></script>
                        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
                        <link rel="stylesheet" href="CSS/style_panelAdmin_page.css">
                        <link rel="stylesheet" href="CSS/style_header.css">
                        <link rel="stylesheet" href="CSS/style_footer.css">
                        <link rel="stylesheet" href="CSS/style_button.css">
                        <link rel="stylesheet" href="CSS/style_link.css">
                        <title>Panel Administracion</title>
                    </head>

                    <body>
                        <nav class="header">
                            <h1 class="header-h1">Panel de Administración</h1>
                            <ul class="nav-ul-cerrar-sesion">
                                <li class="nav-li">
                                    <a id="linkLogout" href="logout.java"> Cerrar sesión</a>
                                </li>
                            </ul>
                        </nav>
                        <nav class="nav-left">
                            <ul class="nav-list">
                                <li class="nav-li"></li>
                                <li class="nav-li" id="bttonTicket">Tickets</li>
                                <li class="nav-li">Especialistas</li>
                                <li class="nav-li">Usuarios</li>
                                <li class="nav-li">Perfil</li>
                                <li class="nav-li">Configuración</li>
                            </ul>
                        </nav>
                        <div class="div-resultado">

                            <%                                if (username != null)
                {
                    //ControladorUsuario cu = new ControladorUsuario();
                    //Usuario u = new Usuario(username.toString());
                }
                else
                {
                    response.sendRedirect("index.html");
                }
            %>
                                <!--cu.getViewUser(u)-->
                                <h1>Panel de Administracion!</h1>
                                <table>
                                    <caption>Tickets</caption>
                                    <thead>
                                        <th>id ticket</th>
                                        <th>Nombre ticket</th>
                                        <th>Descripción</th>
                                        <th>Estado</th>
                                        <th>Solución</th>
                                        <th>Fecha de inicio</th>
                                        <th>Fecha aproximada</th>
                                        <th>Fecha cierre</th>
                                        <th>Comentarios</th>
                                        <th>Areá encargada</th>
                                        <th>Encargado</th>
                                    </thead>
                                    <tbody id="tabla_body">
                                    </tbody>
                                </table>
                        </div>
                        <script src="JS/logout.js"></script>
                        <script src="JS/generarTabla.js"></script>
                    </body>

                    </html>