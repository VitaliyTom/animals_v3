$(document).ready(function () {
    $('select').on('change', function () {
        var idAnimal = this.value;
        console.log(idAnimal);
        $.ajax({
            type: 'POST',
            url: 'http://localhost:88/animal/getAnimalInBaseAjax' + idAnimal,
            // 93.125.1.133
          //  headers:    {'Access-Control-Allow-Origin': '*'},
            contentType: 'application/json; charset=utf-8',
            data: {PathVarId: document.getElementById('select').value},
            dataType: 'json',

            success: function (data) {
                console.log(data);
                var id = JSON.stringify(data.idAnimal);
                                // var img = JSON.stringify(data.imageAnimalDtoByteMedia);
              /*  var lang = JSON.stringify(data.nameAnimal);*/
                var $getAnimalInfo = $('<div align="center" class="info">' +
                    ' <h3 style="color: bisque">' + data.nameAnimal + " " + data.nameCategory+ '</h3> </div>');
                var $getAnimalMediaLeft = $('<div align="center" class="info">' +
                    ' <spring:message code="getAnimal.animal"/> </div>' +
                    '<div align="center" class="get-animal">' +/* id +*/
                    '<img class="img2" src="data:image/png;base64,' + data.logoCategory + '" height="100px" width="100px">' +
                    '<p>' +
                    '<img class="img" src="data:image/png;base64,' + data.imageAnimal + '" height="500px" width="700px">' +
                    '<p>' +
                    '<audio controls="controls" autobuffer="autobuffer">' +
                    '<source src="data:audio/ogg;base64,' + data.audioAnimal + '"/>' +
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
