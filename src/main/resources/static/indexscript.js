

document.addEventListener('DOMContentLoaded', function() {
            fetch("http://localhost:8080/weld")
                .then(response => response.json())
                .then(data => {
                    const tableBody = document.getElementById('weldsTable').getElementsByTagName('tbody')[0];

                    data.forEach(weld => {
                        const row = document.createElement('tr');

                        const nameCell = document.createElement('td');
                        nameCell.textContent = weld.name;
                        row.appendChild(nameCell);

                        const priceCell = document.createElement('td');
                        priceCell.textContent = weld.price;
                        row.appendChild(priceCell);

                        const maxPowerCell = document.createElement('td');
                        maxPowerCell.textContent = weld.maxPower;
                        row.appendChild(maxPowerCell);

                        tableBody.appendChild(row);
                    });
                })
                .catch(error => console.error('Error fetching welds:', error));
        });