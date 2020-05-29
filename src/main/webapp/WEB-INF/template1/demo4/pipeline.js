const names = [];
for (const i of input){
    if (i.job === "programme")
        names.push(i.name);
}


// replace by pipeline
const names = {}
    .filter(i => i.job === "programme")
    .map(i => i.name);

// 使用循环
function acquireData(input) {
    const lines = input.split("\n");
    let firstLine = true;
    const result = [];
    for (const line of lines){
        if (firstLine){
            firstLine = false;
            continue;
        }
        if (line.trim() === "") continue;
        const record = line.split(",");
        if (record[1].trim() === "India")
            result.push({city:record[0].trim(),phone:record[2].trim()})
    }
    return result;
}

// 使用管道替代循环
function acquireData_(input) {
    const lines = input.split("\n");
    return lines
        .slice (1)
        .filter(line => line.trim() !== "")
        .map   (line => line.split(","))
        .filter(fields => fields[1].trim() === "india")
        .map   (fields => ({city:fields[0].trim(),phone:fields[2].trim()}));
}