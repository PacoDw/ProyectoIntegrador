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
                                    <li class="nav-li-Top"></li>
                                    <li class="nav-li-Top" id="bttonCrear" style="display:inline">Crear Ticket</li>
                                    <li class="nav-li-Top" id="bttonModificar" style="display:inline">Modificar Ticket</li>
                                    <li class="nav-li-Top" id="bttonEliminar" style="display:inline">Eliminar Ticket</li>
                                </nav>

                                <form class="form_crear" id="form_crearTicket" action="" method="post" enctype="">
                                    <table class="table-formulario">
                                        <thead>
                                            <tr>
                                                <th class="td-formulario" colspan="2">
                                                    <legend class="form-legend">Nuevo Ticket</legend>
                                                </th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td class="td-formulario">
                                                    <label class="form-label" for="nombreTicket" rowspan="2">Nombre del ticket:</label>
                                                    <input class="form-input-reporte" id="nombreTicket" type="text" name="nombreTicket" placeholder="" autocomplete="off" autofocus
                                                        maxlength="25" required>
                                                    <label class="form-label" for="fecha_aprox">Fecha aproximada de reparación</label>
                                                    <input class="form-input-reporte" id="fecha_aprox" type="datetime-local" name="fecha_aprox" placeholder="" maxlength="25"
                                                        required>
                                                    <label class="form-label" for="grupo_especialista">Área encargada:</label>
                                                    <select name="grupo_especialista" id="grupo_especialista" class="form-input-reporte">
                                                        <option value="" disabled selected>Seleccione una grupo...</option>
                                                    </select>
                                                    <label class="form-label" for="especialista">Especialista:</label>

                                                    <select name="especialista" id="especialista" class="form-input-reporte">
                                                        <option value="" disabled selected>Seleccione un especialista...</option>

                                                    </select>
                                                </td>
                                                <td class="td-formulario">
                                                    <label class="form-label" for="descripcion">Descripción:</label>
                                                    <textarea class="form-input-reporte" name="descripcion" id="descripcion" cols="20" rows="10" placeholder="" maxlength="1000"
                                                        style="height:150px; margin: 0 0 30px 0" required></textarea>
                                                    <label class="form-label" for="comentarios">Comentarios:</label>
                                                    <textarea class="form-input-reporte" name="comentarios" id="comentarios" cols="20" rows="10" placeholder="" maxlength="250"
                                                        style="height:150px; margin: 0 0 30px 0" required></textarea>
                                                </td>
                                                <tr>
                                                    <td class="td-formulario" colspan="2" style="text-align:center; padding: 20px">
                                                        <input class="form-submit" id="bttonTicketSubmit" type="submit" value="Registrar Ticket">
                                                    </td>
                                                </tr>
                                        </tbody>
                                    </table>
                                </form>

                                <form class="form_mod" id="form_modTicket" action="" method="post" enctype="">
                                    <table class="table-formulario">
                                        <thead>
                                            <tr>
                                                <th class="td-formulario" colspan="2">
                                                    <legend class="form-legend">Modificar Ticket</legend>
                                                </th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td class="td-formulario">
                                                    <label class="form-label" for="idTicketMod" rowspan="2">Id del ticket:</label>
                                                    <input class="form-input-reporte" id="idTicketMod" type="text" name="idTicketMod" placeholder="" autocomplete="off" autofocus
                                                        maxlength="25" required readonly>

                                                    <label class="form-label" for="nombreTicketMod" rowspan="2">Nombre del ticket:</label>
                                                    <input class="form-input-reporte" id="nombreTicketMod" type="text" name="nombreTicketMod" placeholder="" autocomplete="off"
                                                        autofocus maxlength="25" required>

                                                    <label class="form-label" for="estadoMod">Estado del ticket:</label>
                                                    <select name="estadoMod" id="estadoMod" class="form-input-reporte">
                                                        <option value="" disabled selected required>Seleccione un estado...</option>
                                                        <option value="Abierto">Abierto</option>
                                                        <option value="Cerrado">Cerrado</option>
                                                    </select>

                                                    <label class="form-label" for="fecha_inicioMod">Fecha de inicio de la reparación</label>
                                                    <input class="form-input-reporte" id="fecha_inicioMod" type="datetime-local" name="fecha_inicioMod" placeholder="" maxlength="25"
                                                        required readonly>

                                                    <label class="form-label" for="fecha_aproxMod">Fecha aproximada de reparación</label>
                                                    <input class="form-input-reporte" id="fecha_aproxMod" type="datetime-local" name="fecha_aproxMod" placeholder="" maxlength="25"
                                                        required>

                                                    <label class="form-label" for="fecha_cierreMod">Fecha de cierre de reparación</label>
                                                    <input class="form-input-reporte" id="fecha_cierreMod" type="datetime-local" name="fecha_cierreMod" placeholder="" maxlength="25"
                                                        required>


                                                </td>
                                                <td class="td-formulario">
                                                    <label class="form-label" for="grupo_especialistaMod">Área encargada:</label>
                                                    <select name="grupo_especialistaMod" id="grupo_especialistaMod" class="form-input-reporte" required style="margin: 0 0 46px 0">
                                                        <option value="" disabled selected>Seleccione una grupo...</option>
                                                    </select>
                                                    <label class="form-label" for="especialistaMod">Especialista:</label>
                                                    <select name="especialistaMod" id="especialistaMod" class="form-input-reporte" required style="margin: 0 0 46px 0">
                                                        <option value="" disabled selected>Seleccione un especialista...</option>
                                                    </select>

                                                    <label class="form-label" for="solucionMod">Solución:</label>
                                                    <textarea class="form-input-reporte" name="solucionMod" id="solucionMod" cols="20" rows="10" placeholder="" maxlength="1000"
                                                        style="height:88px; margin: 0 0 30px 0" required></textarea>

                                                    <label class="form-label" for="descripcionMod">Descripción:</label>
                                                    <textarea class="form-input-reporte" name="descripcionMod" id="descripcionMod" required cols="20" rows="10" placeholder=""
                                                        maxlength="1000" style="height:88px; margin: 0 0 30px 0" required></textarea>
                                                    <label class="form-label" for="comentariosMod">Comentarios:</label>
                                                    <textarea class="form-input-reporte" name="comentariosMod" id="comentariosMod" cols="20" rows="10" placeholder="" maxlength="250"
                                                        style="height:88px; margin: 0 0 30px 0" required></textarea>
                                                </td>
                                                <tr>
                                                    <td class="td-formulario" colspan="2" style="text-align:center; padding: 20px">
                                                        <input class="form-submit" id="bttonModificarSubmit" type="submit" value="Actualizar Ticket">
                                                    </td>
                                                </tr>
                                        </tbody>
                                    </table>
                                </form>

                                <table id="table_id">
                                    <caption style="text-align:center">Tickets</caption>
                                    <thead id="thead-table">
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