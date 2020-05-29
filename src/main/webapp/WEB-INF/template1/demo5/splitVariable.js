function distanceTravelled(scenario,time) {
    let result;
    let acc = scenario.primaryForce / scenario.mass;
    let primaryTime = Math.min(time,scenario.delay);
    result = 0.5 * acc * primaryTime * primaryTime;
    let secondaryTime = time - scenario.delay;
    if (secondaryTime > 0){
        let primaryVelocity = acc * scenario.delay;
        acc = (scenario.primaryForce + scenario.secondaryForce) / scenario.mass;
        result += primaryVelocity * secondaryTime + 0.5 * acc * secondaryTime * secondaryTime;
    }
    return result;
}

function distanceTravelled_(scenario,time) {
    let result;
    const primaryAcc = scenario.primaryForce / scenario.mass;
    const primaryTime = Math.min(time,scenario.delay);
    result = 0.5 * primaryAcc * primaryTime * primaryTime;
    const secondaryTime = time - scenario.delay;
    if (secondaryTime > 0){
        const primaryVelocity = primaryAcc * scenario.delay;
        const secondaryAcc = (scenario.primaryForce + scenario.secondaryForce) / scenario.mass;
        result += primaryVelocity * secondaryTime + 0.5 * secondaryAcc * secondaryTime * secondaryTime;
    }
    return result;
}