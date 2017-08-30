function validate(){
	document.getElementById("expiryDateDiv").innerHTML = "please enter a valid product expiry date";
	var returnval = true;
	
	var today = new Date();
	/*var dd = today.getDate();
	var mm = today.getMonth()+1; 
	var yyyy = today.getFullYear();*/
	
	var prodName = document.getElementById("productName").value;
	var expiryDate = document.getElementById("expiryDate").value;
	var quantity = document.getElementById("quantity").value;
	var price = document.getElementById("price").value;
	
	
	
	if(prodName==""){
		document.getElementById("prodNameDiv").innerHTML = "please enter a valid product name";
		returnval = false;
	}else{
		document.getElementById("prodNameDiv").innerHTML = "";
	}
	
	if(expiryDate<= today){
		document.getElementById("expiryDateDiv").innerHTML = "please enter a valid product expiry date";
		returnval = false;
	}else{
		document.getElementById("expiryDateDiv").innerHTML = "";
	}
	
	if(quantity<=0){
		document.getElementById("quantityDiv").innerHTML = "please enter a valid quantity";
		returnval = false;
	}else{
		document.getElementById("quantityDiv").innerHTML = "";
	}
	
	if(price<50 || price> 1500){
		document.getElementById("priceDiv").innerHTML = "please enter a valid price";
		returnval = false;
	}else{
		document.getElementById("priceDiv").innerHTML = "";
	}
	
	return returnval;
}