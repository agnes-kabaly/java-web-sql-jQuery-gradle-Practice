/**
 * Created by kabaly on 8/29/18.
 */
$(document).ready(function () {
    displayAllFoods();
});

function displayAllFoods() {
    $.get("/allFood", function (response) {
        $("#displayFoods").empty();
        appendDisplayFoods(response);
    });
};

function appendDisplayFoods(response) {
    response.forEach(function (element) {
        var foodH = document.createElement("h3");
        foodH.textContent = element.id + ", " + element.name + ", " + element.calories + ", " + element.groupId;
        $("#displayFoods").append(foodH);
    });
}