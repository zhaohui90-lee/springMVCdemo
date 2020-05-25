class Account {
    get bankCharge(){
        let result = 4.5;
        if (this._dayOverdrawn > 0) result += this.overdraftCharge;
        return result;
    }

    get overdraftCharge(){
        // if (this.type.isPremium){
        //     const baseCharge = 10;
        //     if (this.daysOverdrawn <= 7){
        //         return baseCharge;
        //     }else{
        //         return baseCharge += (this.daysOverdrawn - 7)*0.85;
        //     }
        // }else {
        //     return this.daysOverdrawn * 1.75;
        // }
        return this.type.overdraftCharge(this);
    }
}

class AccountType {
    overdraftCharge(account){
        if (this.isPremium){
            const baseCharge = 10;
            if (account.daysOverdrawn <= 7){
                return baseCharge;
            }else{
                return baseCharge += (account.daysOverdrawn - 7) * 0.85;
            }
        }else {
            return account.daysOverdrawn * 1.75;
        }
    }
}