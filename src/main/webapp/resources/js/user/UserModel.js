function userModel(){

var User = Backbone.Model.extend({
		idAttribute: "username",

        // Will contain three attributes.
        // These are their default values
	 	urlRoot: function() {
	 		return '/helloWorld/user/';
	 	},
        defaults:{
            password: 88,
            role: "ROLE_USER"
        }
    });
return User
}