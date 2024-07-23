let name = document.getElementById("name");
let price = document.getElementById("price");
let maxPower = document.getElementById("maxPower");
let addBtn = document.getElementById("addBtn");
let resultStatus = document.getElementById("resultStatus");

addBtn.addEventListener("click", async function() {
    const response = await fetch("http://localhost:8080/weld",
    {
        method:"POST",
        headers: {
            "Content-Type": "application/json",
          },
        body: JSON.stringify({ name: name.value, price: price.value, maxPower: maxPower.value }),
    });
    if (response.ok){
        resultStatus.innerHTML = "Данные успешно введены!";
    } else {
        resultStatus.innerHTML = "Дурак!";
    }
});