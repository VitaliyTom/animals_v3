$(document).ready(function () {
    $('select').on('change', function () {
        const idAnimal = this.value;
        console.log(idAnimal);

        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/getAllAjax' + idAnimal,
            data: {PathVarId: document.getElementById('select').value},

            success: function (answer) {
                alert("answer" + answer);

            },

        });
    });
});


/* $.ajax({
             url: 'https://api.themoviedb.org/3/search/multi?api_key=d272326e467344029e68e3c4ff0b4059&language=ru-RU',
             data: {query: document.getElementById('myId').value},
             success: function (answer) {

                 answered = answer;
                 console.log(answered);

                 for (i = 0; i < answered.results.length; i++) {
                     json[i] = answered.results[i].name;
                     json[j] = answered.results[j].id;
                     j++;
                     console.log(json[i, j]);
                 }

                 //	do{
                 //	json[i] = answered.results[i].original_name;
                 //	i++;
                 //	}while(i<=answered.results.length);


             }


         });
 */


/*    data: {
                 'animalId': idAnimal,
                 'animalName': nameAnimal,
                 'categoryAnimal': animalCategory,
                 'animalImage': ImageAnimal,
                 'animalAudio': audioAnimal*/