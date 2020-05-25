// 全局变量的重构---封装变量
let defaultOwnerData = {
    firstName:"Martin",
    lastName:"Fowler"
};

export function defaultOwner() {
    return defaultOwnerData;
}

export function setDefaultOwner(arg) {
    defaultOwnerData = arg;
}
// 封装值
const owner1 = defaultOwner();


let globalParam = {
    fName : "jack",
    fAge : 20
};

export function getGlobalParam() {
    return Object.assign({},globalParam);
    // return globalParam;
}

export function setGlobalParam(arg) {
    globalParam = arg;
}