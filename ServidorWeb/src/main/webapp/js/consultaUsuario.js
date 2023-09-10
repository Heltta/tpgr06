function mostrarOcultarDatos(){
    var blur= document.getElementById('blur');
    blur.classList.toggle('active');
    var blur= document.getElementById('popup');
    blur.classList.toggle('active');
}
function habilitaModificar(){
    document.getElementById('txtNombre').disabled= false;
    document.getElementById('txtApellido').disabled= false;
    document.getElementById('passClave').disabled= false;
    document.getElementById('dtFecha').disabled= false;
    document.getElementById('txtNacionalidad').disabled= false;
    document.getElementById('txtDescripcion').disabled= false;
    document.getElementById('txtLink').disabled= false;
    document.getElementById('txtImagen').disabled= false;
}
function ocultarCampos(){
    $('#divNac').css('visibility', 'visible');

    if( $('#divNac').is(":visible") ) {
        $('#divNac').css('display', 'none'); 
      } else {
        $('#divNac').css('display', 'block');
      }
}
$('#mostrar').click(function(e) {
  
    $('#txtNacionalidad').css('visibility', 'visible');

    if( $('#txtNacionalidad').is(":visible") ) {
        $('#txtNacionalidad').css('display', 'none'); 
      } else {
        $('#txtNacionalidad').css('display', 'block');
      }
  });