//FUNCION DE LOGIN
(function(){
    //alert("Login javascript");
    document.getElementById("bttonLogin").addEventListener("click", function(e){
        
        let data = $("#formLogin").serialize();
        $.post("Login", data, function(res, estado, jqXHR){
           if(res === "1")
           {
               alert("Bienvenido");
                   window.location = "PanelAdministracion.jsp";           }
           else
               alert("El usuario o contrasaña son incorrectas...");
        });
        e.preventDefault();
    });
})();


