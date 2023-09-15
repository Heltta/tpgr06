
function openTab(tabName) {
    var tabs = document.getElementsByClassName("tabcontent");
    for (var i = 0; i < tabs.length; i++) {
        tabs[i].style.display = "none";
    }
    document.getElementById(tabName).style.display = "block";
}

function enableEdit(fieldId) {
    var field = document.getElementById(fieldId);
    field.readOnly = !field.readOnly;
}

function displayLastLogin() {
    var lastLogin = document.getElementById("last-login");
    var now = new Date();
    lastLogin.textContent = now.toLocaleString();
}

displayLastLogin();
