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

   /* document.getElementById("bttonValidar").addEventListener("click", function(e){
        let valor = document.getElementById("codigo_referencia").value;

        if(valor !== "" || valor !== null)
        {
            
            let data = { codigo_referencia: valor};
            
            $.post("getTicket", data, function(res, estado, jqXHR){
                window.location = "getTicket";           
                console.log(data);
                alert(data);
            });
        }
        e.preventDefault();
    });*/

})();


