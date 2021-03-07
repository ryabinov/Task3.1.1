showUserInfo();

function showUserInfo(user) {
    fetch('http://localhost:8079/getAuthorizedUser')
        .then(response => response.json())
        .then(user => {
            let tBody = document.getElementById("user_info");
            tBody.innerHTML = "";

            var row = tBody.insertRow(0);
            var cell0 = row.insertCell(0);
            cell0.innerHTML = user.id;
            var cell1 = row.insertCell(1);
            cell1.innerHTML = user.name;
            var cell2 = row.insertCell(2);
            cell2.innerHTML = user.lastName;
            var cell3 = row.insertCell(3);
            cell3.innerHTML = user.age;
            var cell4 = row.insertCell(4);
            cell4.innerHTML = user.email;
            var cell5 = row.insertCell(5);
            cell5.innerHTML = listRoles(user).textContent;
        });
}

read();

function read() {
    let tBody = document.getElementById("tBody");
    tBody.innerHTML = "";
    fetch('http://localhost:8079/getAllUsers')
        .then(response => response.json())
        .then(users => {
            users.forEach(function (user) {
                var row = tBody.insertRow();
                row.setAttribute("id", user.id);
                var cell0 = row.insertCell();
                cell0.innerHTML = user.id;
                var cell1 = row.insertCell();
                cell1.innerHTML = user.name;
                var cell2 = row.insertCell();
                cell2.innerHTML = user.lastName;
                var cell3 = row.insertCell();
                cell3.innerHTML = user.age;
                var cell4 = row.insertCell();
                cell4.innerHTML = user.email;
                var cell5 = row.insertCell();
                cell5.innerHTML = listRoles(user).textContent;

                var cell6 = row.insertCell();
                cell6.innerHTML =
                    '<button type="button" onclick="update(' + user.id + ')" class="btn btn-info btn-sm">Edit</button>';

                var cell7 = row.insertCell();
                cell7.innerHTML =
                    '<button type="button" onclick="getModalDelete(' + user.id + ')" class="btn btn-danger btn-sm">Delete</button>';
            })
        });
}