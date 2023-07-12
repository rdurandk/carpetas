const Component = (function () {
    //Creamos el Constructor del componente
    const Constructor = function (options) {
        this.el = options.el;
        this.data = options.data;
        this.template = options.template;
    }

    //Agregamos los metodos al prototipo del constructor del componente
    //Render UI
    Constructor.prototype.render = function () {
        const $el = d.querySelector(this.el);
        if (!$el) return false;
        $el.innerHTML = this.template(this.data);
        console.log(this.data);
    };

    //Actualziar el State de Forma Reactiva
    Constructor.prototype.setState = function (obj) {

        for (let key in obj) {
            if (this.data.hasOwnProperty(key)) {
                this.data[key] = obj[key];
            }
        }
        this.render();

    };

    //Obtenemos una copia inmutable del State
    Constructor.prototype.getState = function () {
        return JSON.parse(JSON.stringify(this.data))
    };


    return Constructor;

})();