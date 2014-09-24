$('input').click(function() {
	$(this).parent().next().removeClass("hide");
});

$('input').blur(function() {
	$(this).parent().next().addClass("hide");
});

$("#submitUserForm").click(
		function() {
			var valid = true;
			var a = getFieldValue("username")
			if (getFieldValue("username") == null
					|| getFieldValue("username").length == 0) {
				showError("username");
				valid = false
			}
			if (getFieldValue("password") == null
					|| getFieldValue("password").length == 0) {
				showError("password");
				valid = false
			}
			if (getFieldValue("role") == null
					|| getFieldValue("role").length == 0) {
				showError("role");
				valid = false
			}

			if (valid) {	
				$.ajax({
					  url:"/helloWorld/user/add",
					  type:"POST",
					  data: JSON.stringify({"username" : getFieldValue("username"),
						  "password" : getFieldValue("password"),
						  "role" : getFieldValue("role")
						  }),
					  contentType:"application/json; charset=utf-8",
					  dataType:"json",
					  success: function(data,status){
						  if(data.status=="BAD_REQUEST"){
							  showErrorMessage(data.message);
						  }
						  else{
							  showMessage("User saved successfully!");
						  }
					  }
					})
			}
			else {
				return false;
			}

		});

function getFieldValue(fieldid) {
	return $('#' + fieldid).val();
}

function showError(fieldid) {
	var obj = $('#' + fieldid).parent().next();
	obj.removeClass("hide");
	$('#' + fieldid).parent().addClass("has-error");
}
function showMessage(messsage,type){
	var obj = $('#message');
	obj.html(messsage);
	obj.removeClass("hide");
	
}