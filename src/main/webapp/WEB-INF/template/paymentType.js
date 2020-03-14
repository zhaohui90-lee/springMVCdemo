function chooseJsWayStep(){
    console.log("payType:"+payType + "zf:" + zf);
    czFlag = "0";
    closeModal();
    // 费用类型:1.挂号缴费，2 处方缴费，3 住院预缴，5、充值
    var trade_type = "2";
    if(payType==1){//银行卡支付
        $("#chargeList").hide();
        $("#bankPay").show();
// 				$(".btn").attr("onclick", "goHomeAndclose()");
        $("#keyboard_input").val(zf);
        initBankPay("bank",zf);
    }else if(payType==2) {//支付宝扫码支付
        $("#chargeList").hide();
        $("#Scanpay").show();
        $("#keyboard_input").val(zf);
        scancode("alipayBar",zf,trade_type);
    } else if(payType==3){ //微信扫码支付
        $("#chargeList").hide();
        $("#Scanpay").show();
        $("#keyboard_input").val(zf);
        scancode("wechatBar",zf,trade_type);
    }else if(payType==5){// 信用付支付
        $("#chargeList").hide();
        $("#Scanpay").show();
        $("#keyboard_input").val(zf);
        payByCredit("CreditPay",zf,trade_type);
    }else if(payType==4){// 刷脸支付
        $("#chargeList").hide();
        $("#Scanpay").show();
        $("#keyboard_input").val(zf);
        payByFace("alipayZoloz",zf,trade_type);
    }else if(payType==6){// 浙里办
        $("#chargeList").hide();
        $("#Scanpay").show();
        $("#keyboard_input").val(zf);
        dzjkkPayInit("dzjkk",zf,yb,total,trade_type);
    }
    $(".now").addClass("after");
    $(".now").next(".before").eq(0).removeClass("before").addClass("now");
    $(".now").eq(0).removeClass("now");
    $(".n1 span").html("("+zf+"元)");
}

function payInit(paytype,zf,trade_type) {
    const payment = createPaymentType(paytype);
    payment.action(zf);
    payment.pay(zf);
    payment.afterAction(zf);
}

function createPaymentType(paytype) {
    switch (paytype) {
        case 1: return new BankcardPayment(paytype);
        case 2: return new AlipayPayment(paytype);
        case 3: return new WechatPayment(paytype);
        case 4: return new CreditPayment(paytype);
        case 5: return new AlipayZolozPayment(paytype);
        case 6: return new PayByDzjkkPayment(paytype);
        default:
            throw new Error(`unknown type...`);
    }
}

class BasicPayment {
    constructor(paytype) {
        this.paytype = paytype;
    }
    set action(zf){
        $("#chargeList").hide();
        $("#Scanpay").show();
        $("#keyboard_input").val(zf);
    }

    set pay(zf){
        throw new Error("this is basicPatment...");
    }

    set afterAction(zf){
        $(".now").addClass("after")
            .next(".before").eq(0).removeClass("before")
            .addClass("now").eq(0).removeClass("now");
        $(".n1 span").html("("+zf+"元)");
    }
}

class BankcardPayment extends BasicPayment{
    set pay(zf){
        initBankPay("bank",zf);
    }
}

class AlipayPayment extends BasicPayment{
    set pay(zf){
        scancode("alipayBar",zf,trade_type);
    }
}

class WechatPayment extends BasicPayment{
    set pay(zf){
        scancode("wechatBar",zf,trade_type);
    }
}

class CreditPayment extends BasicPayment{
    set pay(zf){
        payByCredit("CreditPay",zf,trade_type);
    }
}

class AlipayZolozPayment extends BasicPayment{
    set pay(zf){
        payByFace("alipayZoloz",zf,trade_type);
    }
}

class PayByDzjkkPayment extends BasicPayment{
    set pay(zf){
        dzjkkPayInit("dzjkk",zf,yb,total,trade_type);
    }
}

