$(document).ready(function () {
    // alert( "готова!" );
    getValId();
});

function getValId(item) {
    var url = "http://localhost:8080/getAllAjax" + item.value;
    //  alert(url);
    console.log(item.value);

    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/getAllAjax' + item.value,
        //fixme
        data: {
            'animalId': idAnimal,
            'animalName': nameAnimal,
            'categoryAnimal': animalCategory,
            'animalImage': ImageAnimal,
            'animalAudio': audioAnimal
        },
        success: function (data) {

            //  alert
        }
    });

}

