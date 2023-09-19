function mostrarOcultarDatos(){
    var blur= document.getElementById('blur');
    blur.classList.toggle('active');
    var blur= document.getElementById('popup');
    blur.classList.toggle('active');
}

document.getElementById("redForm").addEventListener("submit", function(event) {
    event.preventDefault(); // Prevent the default form submission
    var selectedOption = document.getElementById("pageSelect").value;
    window.location.href = selectedOption; // Redirect to the selected page
});