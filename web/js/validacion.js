/*var formulario = document.getElementById("formulario"),
    user = formulario.getElementsByName("user")[0],
    pass = formulario.getElementsByName("psw")[0],
    btn_cancelar = formulario.cancelar,
    btn_acceder = formulario.acceder;
    var validar_user = function(){
      if(user.value === ""){
        user.setAttribute("placeholder","Completa tu nombre de usuario");
        user.className = "error";
        return false;
      }
      else{
        return true;
      }
    }

    var validar_pass = function(){
      if(pass.value === ""){
        pass.setAttribute("placeholder","Completa tu password");
        pass.className = "error";
        return false;
      }
      else{
        return true;
      }


}*/
(function(){
  var user = document.getElementById("formulario").user;
      pass = document.getElementById("formulario").psw;


  var validacion = function(e){

    if(user.value === ""){
      //alert("Paso el if 1");
      user.setAttribute("placeholder","Completa tu nombre");
      user.className = "error";
      return false;
    }
    else if(pass.value === ""){
      /*alert('el if 2');*/
      pass.setAttribute("placeholder","Completa tu password");
      pass.className = "error";
      return false;
    }
    else{
      return true;
    }
  }
  document.getElementById("formulario").onsubmit = validacion;
}());


/*

*/
