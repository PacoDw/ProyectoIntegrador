<%-- 
    Document   : getTicket
    Created on : 27/11/2017, 06:08:42 PM
    Author     : PacoDw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="JS/jquery-3.2.1.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>    
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="CSS/style_getTicket_page.css">
    <link rel="stylesheet" href="CSS/style_header.css">
    <link rel="stylesheet" href="CSS/style_footer.css">
    <link rel="stylesheet" href="CSS/style_button.css">
    <link rel="stylesheet" href="CSS/style_link.css">
    <title>Panel Administracion</title>
    <title>Document</title>
</head>

<body>
    <nav class="header">
        <h1 class="header-h1">Help Desk</h1>
        <ul class="nav-ul-cerrar-sesion">
            <li class="nav-li">
            </li>
        </ul>
    </nav>

    <div class="div-resultado">
        <form class="form_mod" id="form_valTicket" action="" method="post" enctype="">
            <table class="table-formulario">
                <thead>
                    <tr>
                        <th class="td-formulario" colspan="2">
                            <legend class="form-legend">Datos del ticket</legend>
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
                            <select name="grupo_especialistaMod" id="grupo_especialistaMod" class="form-input-reporte" required style="margin: 0 0 22px 0">
                                <option value="" disabled selected>Seleccione una grupo...</option>
                            </select>
                            <label class="form-label" for="especialistaMod">Especialista:</label>
                            <select name="especialistaMod" id="especialistaMod" class="form-input-reporte" required style="margin: 0 0 22px 0">
                                <option value="" disabled selected>Seleccione un especialista...</option>
                            </select>

                            <label class="form-label" for="solucionMod">Solución:</label>
                            <textarea class="form-input-reporte" name="solucionMod" id="solucionMod" cols="20" rows="10" placeholder="" maxlength="1000"
                                style="height:88px; margin: 0 0 22px 0" required></textarea>

                            <label class="form-label" for="descripcionMod">Descripción:</label>
                            <textarea class="form-input-reporte" name="descripcionMod" id="descripcionMod" required cols="20" rows="10" placeholder=""
                                maxlength="1000" style="height:88px; margin: 0 0 22px 0" required></textarea>
                            <label class="form-label" for="comentariosMod">Comentarios:</label>
                            <textarea class="form-input-reporte" name="comentariosMod" id="comentariosMod" cols="20" rows="10" placeholder="" maxlength="250"
                                style="height:88px; margin: 0 0 22px 0" required></textarea>
                        </td>
                </tbody>
            </table>
        </form>
    </div>
    <script type="text/javascript" src="JS/getTicket.js"></script>
</body>

</html>