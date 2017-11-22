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
                        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
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
                                <nav id="nav-crud">
                                    <li class="nav-li"></li>
                                    <li class="nav-li" id="bttonCrear" style="display:inline">Crear Ticket</li>
                                    <li class="nav-li" id="bttonModificar" style="display:inline">Modificar Ticket</li>
                                    <li class="nav-li" id="bttonEliminar" style="display:inline">Eliminar Ticket</li>
                                </nav>
                                
                                <form class="form_crear" id="form_crearTicket" action="" method="post" enctype="">
                                    <table>
                                        <thead>
                                            <tr>
                                                <th colspan="2">
                                                    <legend class="form-legend">Nuevo Ticket</legend>
                                                </th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td><label class="form-label" for="nombreTicket">Nombre del ticket:</label>
                                                </td>
                                                <td><input class="form-input-reporte" id="nombreTicket" type="text" name="nombreTicket" placeholder="" autocomplete="off" autofocus maxlength="25"
                                                        required></td>
                                            </tr>
                                            <tr>
                                                    <td><label class="form-label" for="descripcion">Descripción:</label></td>
                                                    <td><textarea class="form-input-reporte" name="descripcion" id="descripcion" cols="20" rows="10" placeholder="" maxlength="1000"
                                                            style="height:150px; margin-bottom:0" required></textarea></td>
                                            </tr>
                                            <tr>
                                                <td><label class="form-label" for="fecha_aprox">Fecha aproximada de reparación</label></td>
                                                <td><input class="form-input-reporte" id="fecha_aprox" type="date" name="fecha_aprox" placeholder="" maxlength="25" required></td>
                                            </tr>
                                            <tr>
                                                <td><label class="form-label" for="comentarios">Comentarios:</label></td>
                                                <td><textarea class="form-input-reporte" name="comentarios" id="comentarios" cols="20" rows="10" placeholder="" maxlength="250"
                                                        style="height:150px; margin-bottom:0" required></textarea></td>
                                            </tr>
                                            <tr>
                                                <td>
                                                        <label class="form-label" for="grupo_especialista">Grupo de especialidad:</label>
                                                </td>
                                                <td>
                                                    <select name="grupo_especialista" id="grupo_especialista">
                                                            <option value="" disabled selected>Seleccione una grupo...</option>
                                                    </select>

                                                </td>
                                            </tr>
                                            <tr>
                                                    <td>
                                                        <label class="form-label" for="especialista">Especialista:</label>
                                                    </td>
                                                    <td>
                                                        <select name="especialista" id="especialista">
                                                                <option value="" disabled selected>Seleccione un especialista...</option>
                                                                
                                                        </select>
                                                        
                                                    </td>
                                                </tr>
                                            <tr>
                                                <td colspan="2" style="text-align:center; padding: 20px"><input class="form-submit" type="submit" value="Registrar"></td>
                                            </tr>
                                            <tr>
                                                <td colspan="2" style="text-align:center">
                                                    <a class="form-link" href="http://">
                                                        ¿Olvidó su nombre de usuario o contraseña?
                                                    </a>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </form>




                                <table id="table_id">
                                    <caption style="text-align:center">Tickets</caption>
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
                        <script src="JS/crearTicket.js"></script>
                    </body>

                    </html>