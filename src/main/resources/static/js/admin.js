function renderUserTable(user, table) {

    let innerHtml =
        '<thead class="thead-dark">' +
        '   <tr>' +
        '       <th scope="col">ID</th>' +
        '       <th scope="col">Email</th>' +
        '       <th scope="col">FirstName</th>' +
        '       <th scope="col">LastName</th>' +
        '   </tr>' +
        '</thead>' +
        '<tbody>' +
        '<tr>' +
        '  <th scope="row">' + user['id'] + '</th>' +
        '  <td>' + user['email'] + '</td>' +
        '  <td>' + user['firstName'] + '</td>' +
        '  <td>' + user['lastName'] + '</td>' +
        '</tr>' +
        '</tbody>';

    table.html(innerHtml);

}

const findUser = async id => {
    const resp = await fetch(`/users/${id}`);
    const user = await resp.json();

    const table = $('#table');

    renderUserTable(user, table);
}

function _findUser(user_id) {

   console.log(user_id)

    const data = {
        "id": user_id
    };

    $.ajax({
        type: "GET", // метод запроса
        url: `/users/${user_id}`, // url запроса
        // что происходит, если запрос прошел успешно
        success: function (response) {
            // рисуем таблицу на основе ответа на запрос
            console.log(response)
            renderUserTable(response, $('#table'))
        },
        // // тип данных, который мы отправляем
        // dataType: "json",
        // contentType: "application/json"
    })

}

function renderFilmTable(film, table) {

    let innerHtml =
        '<thead class="thead-dark">' +
        '   <tr>' +
        '       <th scope="col">ID</th>' +
        '       <th scope="col">Заголовок</th>' +
        '       <th scope="col">Бюджет</th>' +
        '       <th scope="col">Год</th>' +
        '   </tr>' +
        '</thead>' +
        '<tbody>' +
        '<tr>' +
        '  <th scope="row">' + film['id'] + '</th>' +
        '  <td>' + film['title'] + '</td>' +
        '  <td>' + film['budget'] + '</td>' +
        '  <td>' + film['year'] + '</td>' +
        '</tr>' +
        '</tbody>';

    table.html(innerHtml);

}

const findFilm = async id => {
    const resp = await fetch(`/films/${id}`);
    const user = await resp.json();

    const table = $('#table');

    renderFilmTable(user, table);
}

function _findUser(film_id) {

   console.log(film_id)

    const data = {
        "id": film_id
    };

    $.ajax({
        type: "GET", // метод запроса
        url: `/users/${film_id}`, // url запроса
        // что происходит, если запрос прошел успешно
        success: function (response) {
            // рисуем таблицу на основе ответа на запрос
            console.log(response)
            renderFilmTable(response, $('#table'))
        },
        // // тип данных, который мы отправляем
        // dataType: "json",
        // contentType: "application/json"
    })

}