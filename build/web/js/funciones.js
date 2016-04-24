function limpiar_user(){
  var user = document.getElementById("formulario").user;
  user.setAttribute("placeholder","Nombre");
  user.className = "normal";
}

function limpiar_pass(){
  var pass = document.getElementById("formulario").psw;
  pass.setAttribute("placeholder","Password");
  pass.className = "normal";
}
document.getElementById("formulario").user.onfocus = limpiar_user;
document.getElementById("formulario").psw.onfocus = limpiar_pass;
