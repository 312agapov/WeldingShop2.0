let editBtn = document.getElementById("editBtn");

document.addEventListener('DOMContentLoaded', function() {
            fetch("http://localhost:8080/weld")
                .then(response => response.json())
                .then(data => {
                    const tableBody = document.getElementById('weldsTable').getElementsByTagName('tbody')[0];

                    data.forEach(welding => {
                        const row = document.createElement('tr');

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