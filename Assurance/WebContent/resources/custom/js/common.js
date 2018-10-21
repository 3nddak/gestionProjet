
chneminPrincipal = document.location.pathname;
chemin = document.location.host + "/" + chneminPrincipal.split("/")[1] + "/server";

if (window.location.protocol === "http:") {
    webSocket = new WebSocket("ws://" + chemin);
}
if (window.location.protocol === "https:") {
    webSocket = new WebSocket("wss://" + chemin);
}
//variable contenant les affaire non traite
webSocket.onerror = function (event) {
    // alert("pseudovalues");
};


webSocket.onopen = function (event) {


};


webSocket.onmessage = function (event) {

    var data = JSON.parse(event.data);

    try {

        newProposition();

    } catch (err) {

    }
    try {
        newSms();
    } catch (err) {

    }
    try {

        notificationAnnulation();
    } catch (err) {

    }

};
