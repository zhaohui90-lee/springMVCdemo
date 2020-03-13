export default function createStatementData(invoice,plays) {
    const result = {};
    result.customer = invoice.customer;
    result.performances = invoice.performances.map(enrichPerformance);
    result.totalAmount = totalAmount(result);
    result.totalAmountCredits = totalVolumeCredits(result);
    return result;

    function enrichPerformance(aPerformance) {
        const caculator = new PerformanceCalculator(aPerformance,playFor(aPerformance));
        const result = Object.assign({},aPerformance);
        result.play = playFor(result);
        result.amount = amountFor(result);
        result.volumeCredits = volumeCreditsFor(result);
        return result;
    }

    class PerformanceCalculator{
        constructor(aPerformance,aPlay) {
            this.performance = aPerformance;
            this.play = aPlay;
        }

        get amount(){
            throw new Error(`unknown type:${playFor(aPerformance).type}`);
        }

        get volumeCredits(){
            return Math.max(aPerformance.audience - 30,0);;
        }
    }

    class TragedyCalculator extends PerformanceCalculator{
        get amount(){
            let result = 40000;
            if (this.performance.audience > 30){
                result += 1000 * (this.performance.audience - 30);
            }
            return result;
        }
    }

    class ComedyCalculator extends PerformanceCalculator{
        get amount(){
            let result = 30000;
            if (this.performance.audience > 20){
                result += 10000 + 500 * (this.performance.audience - 20);
            }
            result += 300 * this.performance.audience;
            return result;
        }

        get volumeCredits(){
            return super.volumeCredits + Math.floor(aPerformance.audience / 5);
        }
    }

    function createPerformanceCalculator(aPerformance,aPlay) {
        switch (aPlay.type) {
            case "tragedy": return new TragedyCalculator(aPerformance,aPlay);
            case "comedy": return new ComedyCalculator(aPerformance,aPlay);
            default:
                throw new Error(`unknown type:${aPlay.type}`);
        }
    }

    function totalAmount(data) {
        let result = 0;
        for (let perf of data.performances){
            // print line for this order
            result += perf.amount;
        }
        return result;
    }

    function totalVolumeCredits(data) {
        let volumeCredits = 0;
        for (let perf of data.performances){
            volumeCredits += perf.volumeCredits;
        }
        return volumeCredits;
    }

    function playFor(aPerformance) {
        return plays[aPerformance.playID];
    }

    function amountFor(aPerformance) {
        return new PerformanceCalculator(aPerformance,playFor(aPerformance)).amount;
    }

    function volumeCreditsFor(aPerformance) {
        return new PerformanceCalculator(aPerformance,playFor(aPerformance)).volumeCredits;
    }
}