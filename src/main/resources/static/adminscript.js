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
        loadAllWeldings();
        resultStatus.innerHTML = "Данные успешно введены!";
    } else {
        resultStatus.innerHTML = "Дурак!";
    }
});

document.addEventListener('DOMContentLoaded', function() {
            loadAllWeldings();
        });

async function loadAllWeldings(){
    const tableBody = document.getElementById('weldsTable').getElementsByTagName('tbody')[0];
    tableBody.innerHTML = "";
    fetch("http://localhost:8080/weld", {method:"GET"})
        .then(response => response.json())
        .then(data => {
            data.forEach(weld => {
                const row = document.createElement('tr');

                const idCell = document.createElement('td');
                idCell.textContent = weld.id;
                row.appendChild(idCell);

                const nameCell = document.createElement('td');
                nameCell.textContent = weld.name;
                row.appendChild(nameCell);

                const priceCell = document.createElement('td');
                priceCell.textContent = weld.price;
                row.appendChild(priceCell);

                const maxPowerCell = document.createElement('td');
                maxPowerCell.textContent = weld.maxPower;
                row.appendChild(maxPowerCell);

                const editCell = document.createElement('td');
                const editButton = document.createElement('button');
                editButton.textContent = 'Изменить';
                editButton.addEventListener('click', () => {
                    editWelding(weld,row);
                });
                editCell.appendChild(editButton);
                row.appendChild(editCell);

                const deleteCell = document.createElement('td');
                const deleteButton = document.createElement('button');
                deleteButton.textContent = 'Удалить';
                deleteButton.addEventListener('click', () => {
                    deleteWelding(weld.id);
                });
                deleteCell.appendChild(deleteButton);
                row.appendChild(deleteCell);

                tableBody.appendChild(row);
            });
        })
        .catch(error => console.error('Error fetching welds:', error));
}

async function deleteWelding(weldId) {
    try {
        const response = await fetch("http://localhost:8080/weld/" + weldId, {
            method: "DELETE",
        });
        if (response.ok) {
            resultStatus.innerHTML = "Запись успешно удалена!";
            loadAllWeldings();
        } else {
            resultStatus.innerHTML = "Ошибка при удалении записи!";
        }
    } catch (error) {
        console.error('Error deleting welding:', error);
        resultStatus.innerHTML = "Ошибка при удалении записи!2";
    }
}

async function editWelding(weld, row) {
    let cells = row.getElementsByTagName('td');

    let input1 = document.createElement('input');
    input1.value = weld.name;
    cells[1].innerHTML = "";
    cells[1].appendChild(input1);

    let input2 = document.createElement('input');
    input2.value = weld.price;
    cells[2].innerHTML = "";
    cells[2].appendChild(input2);

    let input3 = document.createElement('input');
    input3.value = weld.maxPower;
    cells[3].innerHTML = "";
    cells[3].appendChild(input3);

    let button = document.getElementById('saveBtn');
    button.style.display = "block";

    button.addEventListener("click", async function() {
        const response = await fetch("http://localhost:8080/weld",
        {
            method:"PUT",
            headers: {
                "Content-Type": "application/json",
              },
            body: JSON.stringify({ id: weld.id, name: input1.value, price: input2.value, maxPower: input3.value }),
        });
        if (response.ok){
            loadAllWeldings();
            button.style.display = "none";
            resultStatus.innerHTML = "Данные успешно изменены!";
        } else {
            resultStatus.innerHTML = "Дурак!";
        }
    });


}
