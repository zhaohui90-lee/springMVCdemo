function sampleProvinceData() {
    return {
        "name" : "Asia",
        "producer" : [
            {
                "name" : "Byzantium",
                "cost" : 10,
                "production" : 9
            },
            {
                "name" : "Attalia",
                "cost" : 12,
                "production" : 10
            },
            {
                "name" : "Sinope",
                "cost" : 10,
                "production" : 6
            }
        ],
        "demand" : 30,
        "price" : 20
    };
}

class Producer {
    constructor(aProvince,data) {
        this._province = aProvince;
        this._cost = data.cost;
        this._name = data.name;
        this._production = data.production || 0;
    }

    get name(){
        return this._name;
    }

    get cost(){
        return this._cost;
    }

    set cost(arg){
        this._cost = arg;
    }

    get production(){
        return this._production;
    }

    set production(amountStr){
        const amount = parseInt(amountStr);
        const newProduction = Number.isNaN(amount) ? 0:amount;
        this._province.totalProduction += newProduction - this._production;
        this._production = newProduction;
    }
}

class Province {
    constructor(doc) {
        this._name = doc.name;
        this._producers = [];
        this._totalProduction = 0;
        this._demand = doc.demand;
        this._price = doc.price;
        doc._producers.forEach(d => this.addProducer(new Producer(this,d)));
    }

    addProducer(arg){
        this._producers.push(arg);
        this._totalProduction += arg.production;
    }

    get name(){
        return this._name;
    }

    get producers(){
        return this._producers.slice();
    }

    get totalProduction(){
        return this._totalProduction;
    }

    set totalProduction(arg){
       this._totalProduction = arg;
    }

    get demand(){
        return this._demand;
    }

    set demand(arg){
        this._demand = arg;
    }

    get price(){
        return this._price;
    }

    set price(arg){
        this._price = arg;
    }
}