class Order2 {
    constructor(quantity,item) {
        this._quantity = quantity;
        this._item = item;
    }
    // 以查询取代临时变量
    get price(){
        return this.basePrice * this.discountFactor;
    }
    get basePrice(){
        return this._quantity * this._item.price;
    }
    get discountFactor(){
        let discountFactor = 0.98;
        if (this.basePrice > 1000) discountFactor -= 0.03;
        return discountFactor;
    }
}