function trigger(optionValue) {
    var select = document.getElementById("paquete");
    var options = select.options;

    for (var i = 0; i < options.length; i++) {
		var id= options[i].value;
		
      if (id.search(optionValue) !== -1) {
        options[i].style.display = "none";
      }else{
		options[i].style.display = "block";
	  }
    }
  }