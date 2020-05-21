class Bird {
    constructor(birdObject) {
        Object.assign(this,birdObject);
    }
    get plumage(){
        switch (this.type) {
            case 'EuropeanSwallow':
                return 'average';
            case 'AfricanSwallow':
                return (this.numberOfCoconuts > 2)? 'tired':'average';
            default:
                return 'unknown';
        }
    }
    get airSpeedVelocity(){
        switch (this.type) {
            case 'EuropeanSwallow':
                return 35;
            case 'AfricanSwallow':
                return 40;
            default:
                return null;
        }
    }
}

function plumages(birds) {
    return new Map(birds.map(b => [b.name,plumage(b)]));
}

function speeds(birds) {
    return new Map(birds.map(b =>[b.name,airSpeedVelocity(b)]));
}

function plumage(bird) {
    return createBird(bird).plumage;
}

function airSpeedVelocity(bird) {
    return createBird(bird).airSpeedVelocity;
}

function createBird(bird) {
    switch (bird.type) {
        case 'EuropeanSwallow':
            return new EuropeanSwallow(bird);
        case 'AfricanSwallow':
            return new AfricanSwallow(bird);
        default:
            return new Bird(bird);
    }
}

class EuropeanSwallow extends Bird{}

class AfricanSwallow extends Bird{}