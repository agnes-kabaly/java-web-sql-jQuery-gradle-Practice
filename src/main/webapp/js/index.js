$(document).ready(function () {
    displayAllFoods();
    groupButtons();
});

function displayAllFoods() {
    $.get("/allFood", function (response) {
        $("#displayFoods").empty();
        appendDisplayFoods(response);
    });
};

function groupButtons() {
    $.get("/allGroup", function (response) {
        response.forEach(function (element) {
            var gButt = document.createElement("button");
            gButt.textContent = element.name;

            var groupOptions = document.createElement("options");
            groupOptions.textContent = element.id;
            $("#groupId").append(groupOptions);

            gButt.onclick = function () {
                var actualId = element.id;
                $.get("/filtered", {actId:actualId}, function (response) {
                    $("#displayFoods").empty();
                    appendDisplayFoods(response);
                });
            };
            $("#groupButtons").append(gButt);
        });
    });
}

function appendDisplayFoods(response) {
    response.forEach(function (element) {
        var foodH = document.createElement("h3");
        foodH.textContent = element.id + ", " + element.name + ", " + element.calories + ", " + element.groupId;
        $("#displayFoods").append(foodH);
    });
}
