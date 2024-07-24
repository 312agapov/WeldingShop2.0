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

document.addEventListener('DOMContentLoaded', function() {
            fetch("http://localhost:8080/weld")
                .then(response => response.json())
                .then(data => {
                    const tableBody = document.getElementById('weldsTable').getElementsByTagName('tbody')[0];

                    data.forEach(welding => {
                        const row = document.createElement('tr');

                        const idCell = document.createElement('td');
                        idCell.textContent = welding.id;
                        row.appendChild(idCell);

                        const nameCell = document.createElement('td');
                        nameCell.textContent = welding.name;
                        row.appendChild(nameCell);

                        const priceCell = document.createElement('td');
                        priceCell.textContent = welding.price;
                        row.appendChild(priceCell);

                        const maxPowerCell = document.createElement('td');
                        maxPowerCell.textContent = welding.maxPower;
                        row.appendChild(maxPowerCell);

                        tableBody.appendChild(row);
                    });
                })
                .catch(error => console.error('Error fetching welds:', error));
        });

