function connect() {
    ws = new WebSocket('ws://localhost:8080/tweets');
    ws.onmessage = function (data) {
        addToUi(data.data);
    }
}

function addToUi(message) {
    var jsonMsg = JSON.parse(message);
    if(jsonMsg.status.user.followersCount > 1500){
        document.querySelector('#messages').innerHTML += "<tr><th>" + jsonMsg.status.createdAt + "</th><th>" + jsonMsg.status.user.followersCount + "</th><th>" + jsonMsg.status.user.name + "</th><th>" + jsonMsg.status.text + "</th></tr>";
    }
}