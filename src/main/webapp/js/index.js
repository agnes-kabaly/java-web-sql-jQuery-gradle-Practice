$(document).ready(function () {
    displayAllFoods();
    groupButtons();

    $("#addFButt").click(function () {
        addFood();
        displayAllFoods();
    });

    $("#allFoods").click(function() {
        displayAllFoods();
    });

});

function displayAllFoods() {
    $.get("/allFood", function (response) {
        $("#displayFoods").empty();
        appendDisplayFoods(response);
    });
}

function groupButtons() {
    $.get("/allGroup", function (response) {
        response.forEach(function (element) {
            var gButt = document.createElement("button");
            gButt.textContent = element.name;

            var groupOptions = document.createElement("option");
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

function addFood() {
    var fName = $("#name").val();
    var fCalories = $("#calories").val();
    var fGroupId = $("#groupId").val();
    var json = JSON.stringify({name:fName, calories:fCalories, groupId:fGroupId});

    $.post("/addFood", {json:json});

}

function appendDisplayFoods(response) {
    response.forEach(function (element) {
        var foodH = document.createElement("h3");
        foodH.textContent = element.id + ", " + element.name + ", " + element.calories + ", " + element.groupId;
        $("#displayFoods").append(foodH);
    });
}
