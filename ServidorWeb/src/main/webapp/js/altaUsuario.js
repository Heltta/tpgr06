function postulante(){
	document.getElementById("empresa").style.display = "none";
    document.getElementById("postulante").style.display = "block";
    document.getElementById("descripcion").removeAttribute("required");
    document.getElementById("url").removeAttribute("required");
    document.getElementById("nacionalidad").setAttribute("required","");
    document.getElementById("fecha").setAttribute("required","");
}

function empresa(){
	document.getElementById("empresa").style.display = "block";
    document.getElementById("postulante").style.display = "none";
    document.getElementById("descripcion").setAttribute("required","");
    document.getElementById("url").setAttribute("required","");
    document.getElementById("nacionalidad").removeAttribute("required");
    document.getElementById("fecha").removeAttribute("required");
}