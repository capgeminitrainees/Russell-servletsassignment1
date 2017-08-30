function validate(){
	
	var returnval = true;
	var userName = document.getElementById("userName").value;
	
	var userPassword = document.getElementById("userPassword").value;
	
	if( userName==""){
		document.getElementById("errName").innerHTML = "Please enter a valid name";
			returnval = false;
	}else{
		document.getElementById("errName").innerHTML = "";
	}
	
	if(userPassword==""){
		document.getElementById("errPassword").innerHTML = "Please enter a valid password";
			returnval = false;
	}else{
		document.getElementById("errPassword").innerHTML = "";
	}
	
	return returnval;
}