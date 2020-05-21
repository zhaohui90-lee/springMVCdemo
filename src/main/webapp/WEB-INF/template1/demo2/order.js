class Order {
    constructor(value) {
        this._value = value;
    }
    get priorityString(){
        return this._priority.toString();
    }
    set priority(aString){
        this._priority = new Priority(aString);
    }
    toString(){
        return this._value;
    }
}
class Priority {
    constructor(value) {
        if (value instanceof Priority) return value;
        if (Priority.legalValues().include(value))
            this._value = value;
        else
            throw new Error(`<${value}> is invalid for Priority`);
    }
    toString(){
        return this._value;
    }
    get _index(){
        return Priority.legalValues().findIndex(s => s === this._value);
    }
    static legalValues(){
        return ['low','normal','high','rush'];
    }

    equals(other){
        return this._index === other._index;
    }
    higherThan(other){
        return this._index > other._index;
    }
    lowerThan(other){
        return this._index < other._index;
    }
}