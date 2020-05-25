function chooseJsWayStep(){
    // 费用类型:1.挂号缴费，2 处方缴费，3 住院预缴，5、充值
    const trade_type = "2";
    $("#chargeList").hide();
    $("#Scanpay").show();
    $("#keyboard_input").val(zf);
    switch (payType) {
        case 1: initBankPay("bank",zf);
            break;
        case 2: scancode("alipayBar",zf,trade_type);
            break;
        case 3: scancode("wechatBar",zf,trade_type);
            break;
        case 4: payByFace("alipayZoloz",zf,trade_type);
            break;
        case 5: payByCredit("CreditPay",zf,trade_type);
            break;
        case 6: dzjkkPayInit("dzjkk",zf,yb,total,trade_type);
            break;
        default:
            throw new Error(`unknown type...`);
    }
    $(".now").addClass("after")
        .next(".before").eq(0).removeClass("before")
        .addClass("now").eq(0).removeClass("now");
    $(".n1 span").html("("+this._zf+"元)");
}

function payInit(paytype,data) {
    const payment = createPaymentType(paytype,data);
    payment.action(data.zf);
    payment.pay(data);
    payment.afterAction(zf);
}

function createPaymentType(paytype,data) {
    switch (paytype) {
        case 1: return new BankcardPayment(data);
        case 2: return new AlipayPayment(data);
        case 3: return new WechatPayment(data);
        case 4: return new CreditPayment(data);
        case 5: return new AlipayZolozPayment(data);
        case 6: return new PayByDzjkkPayment(data);
        default:
            throw new Error(`unknown type...`);
    }
}

class BasicPayment {
    constructor(data) {
        this._zf = data.zf;
        this._yb = data.yb;
        this._total = data.total;
    }

    action(){
        $("#chargeList").hide();
        $("#Scanpay").show();
        $("#keyboard_input").val(this._zf);
    }

    pay(data){
        throw new Error("this is basicPayment...");
    }

    afterAction(){
        $(".now").addClass("after")
            .next(".before").eq(0).removeClass("before")
            .addClass("now").eq(0).removeClass("now");
        $(".n1 span").html("("+this._zf+"元)");
    }
}

class BankcardPayment extends BasicPayment{
    pay(data){
        initBankPay("bank",data.zf);
    }
}

class AlipayPayment extends BasicPayment{
    pay(data){
        scancode("alipayBar",data.zf);
    }
}

class WechatPayment extends BasicPayment{
    pay(data){
        scancode("wechatBar",zf);
    }
}

class CreditPayment extends BasicPayment{
    pay(data){
        payByCredit("CreditPay",data.zf);
    }
}

class AlipayZolozPayment extends BasicPayment{
    pay(data){
        payByFace("alipayZoloz",data.zf);
    }
}

class PayByDzjkkPayment extends BasicPayment{
    pay(data){
        dzjkkPayInit("dzjkk",data.zf,data.yb,data.total);
    }
}

