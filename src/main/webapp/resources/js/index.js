$(document).ready(function () {
    $('select').on('change', function () {
        const idAnimal = this.value;
        console.log(idAnimal);

        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/getAnimalInBaseAjax' + idAnimal,
            data: {PathVarId: document.getElementById('select').value},

            success: function (data) {

                var id = JSON.stringify(data.idAnimalDtoByteMedia);
                // var img = JSON.stringify(data.imageAnimalDtoByteMedia);
                var lang = JSON.stringify(data.nameAnimalDtoByteMedia);

                var $getAnimalInfo = $('<div align="center" class="info">' +
                    ' <h3 style="color: bisque">' + data.nameAnimalDtoByteMedia + ' - ' + data.animalCategoryDtoByteMedia+ '</h3> </div>');

                var $getAnimalMediaLeft = $('<div align="center" class="info">' +
                    ' <spring:message code="getAnimal.animal"/> </div>' +
                    '<div align="center" class="get-animal">' + id +
                    '<img class="img" src="data:image/png;base64,' + data.imageAnimalDtoByteMedia + '" height="500px" width="700px">' +
                    '<p>' +
                    '<audio controls="controls" autobuffer="autobuffer">' +
                    '<source src="data:audio/ogg;base64,' + data.audioAnimalDtoByteMedia + '"/>">' +
                    '</audio>' +
                    '</p>' +
                    '</div>');

                //               console.log(id);
//              $('#ga').append($getAnimalMediaLeft);  //не обнуляет див - добавляет к предыдущему!

                $('#ga2').html($getAnimalInfo);
                $('#ga').html($getAnimalMediaLeft);
            },
        });
    });
});


