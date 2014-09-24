
function UserCollection(){
	
// Create a collection of services
    var Userlist = Backbone.Collection.extend({
        model: userModel
        
    });
 
    return Userlist;
}