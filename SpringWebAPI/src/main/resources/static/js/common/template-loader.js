var app = app || {};

app.templateLoader = (function templateLoader() {
    return {
        loadTemplate: function (element, template, callback) {
            $.ajax({
                type: "GET",
                url: 'fragments/' + template + '.html',
                dataType: "html"
            }).then((template) => {
                $(element).html(template);
                if(callback) callback();
            }).catch((error) => {
                console.log("Error loading template!");
                console.log("Error: " + error);
            })
        }
    }
})();