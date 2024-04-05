function validateForm(){
	  // read the data//
	  var proId = document.getElementbyId("ProID").value;
	  var proName = document.getElementbyId("ProName").value;
	  var proPrice = document.getElementbyId("ProPrice").value;
	  var proBrand = document.getElementbyId("Probrand").value;
	  var proMadeIn = document.getElementbyId("ProMadeIN").value;
	  var mfgDate=document.getElementbyId("ProMfg").value;
	  var expDate=document.getElementbyId("ProExp").value;
	  
	  
	  
	  if(proId.trim()==="" || proName.trim()==="" || proPrice.trim()==="" || proBrand.trim()==="" || proMadeIn.trim()===""){
		  alert("all fields must filledout");
		  return false;
	  }    if( proName.length >50 || proBrand.length >50 ){
        alert("Name should be less than 50 characters");
        return false;
    }

    if( parseFloat(proPrice) <0 ){
        alert("Price must be positive");
        return false;
    }

    //Converting strings to date objects.
    let MFGdate = new Date(mfgDate);
    let EXPdate = new Date(expDate);

    if( MFGdate > EXPdate ){
        alert("Mfg Date must be less than Exp Date");
        return false;
    }
    return true;
  }