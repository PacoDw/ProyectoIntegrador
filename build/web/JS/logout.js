//FUNCION DE LOGOUT
(function(){
    document.getElementById("linkLogout").addEventListener("click", function(e){
        $.post("Logout", null, function(res, estado, jqXHR){
            alert(res);
           if(res === "Sesion Terminada")
           {
               alert("Goodbye...\n Sesión terminada");
               setTimeout(function(){
                   window.location = "index.html";
               }, 300);
           }
           else
               alert("No se pudo cerrar sesión...");
        });
        e.preventDefault();
    });
})();