    var App = Backbone.View.extend({
    	template: _.template('<a href="#/todos/p<%= page %>">next page</a>'),
        // Base the view on an existing element
        el: $('#main'),

        initialize: function(){

            // Listen for the change event on the collection.
            // This is equivalent to listening on every one of the 
            // service objects in the collection.
            this.listenTo(services, 'change', this.render);

            // Create views for every one of the services in the
            // collection and add them to the page

          this.render();
        },

        render: function(){

            // Calculate the total order amount by agregating
            // the prices of only the checked elements

            var total = 0;

            _.each(services.getChecked(), function(elem){
                total += elem.get('price');
            });

            // Update the total price
            this.total.text('$'+total);

            return this;
        }
    });