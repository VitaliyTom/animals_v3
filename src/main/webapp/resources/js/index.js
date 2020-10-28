import modal from './modal.js';

const buttonCheck = document.querySelector('div.button.check');
const getAnimal = document.querySelector('.get_Animal');
const header = document.querySelector('.header ');
const containerGetAnimal = document.querySelector('.container_get_Animal  ');
const animalList = Array.from(document.querySelectorAll('.animal_List'));
const checkAnimal = document.querySelector('.check_Animal');
const modalMessage = document.querySelector('.modal');
const spinner = document.querySelector('.spinnerAnimal');
const buttonIndexMain = document.querySelector('.button.index.main');

// вызов модалльного окна
modal();
getAminal(37);

// добавление эффекта блюр
buttonCheck.addEventListener('click', (event) => {
	getAnimal.classList.add('active');
	header.classList.add('blur');
	containerGetAnimal.classList.add('blur');
	modalMessage.classList.add('blur');
	buttonIndexMain.classList.add('blur');
});

// вывод списка животных
checkAnimal.addEventListener('click', (event) => {
	spinner.classList.add('active');
	animalList.forEach((item) => {
		if (event.target.closest('.animal_List') === item) {
			console.log(item.children[0].value);
			getAminal(item.children[0].value);
		}
	});
	getAnimal.classList.remove('active');
	header.classList.remove('blur');
	containerGetAnimal.classList.remove('blur');
});

// при выборе животного закрыть список и убрать эффект блюр
getAnimal.addEventListener('click', (event) => {
	getAnimal.classList.remove('active');
	header.classList.remove('blur');
	containerGetAnimal.classList.remove('blur');
	modalMessage.classList.remove('blur');
	buttonIndexMain.classList.remove('blur');
});

// фетч запрос на получение животного
async function getAminal(idAnimal) {
	const response = await fetch('getAnimalInBaseAjax' + idAnimal);
	const parsed = await response.json();

	const categoryName = document.querySelector('.category_name');
	const animalName = document.querySelector('.animal_Name');
	const logoImg = document.querySelector('.logo_img');
	const imgAnimal = document.querySelector('.img_Animal');
	const audioControls = document.querySelector('.audio_Controls');
	const wrapperAudio = document.querySelector('.wrapper_Audio');

	const audio = `<audio class="audio_Controls" controls="controls" autobuffer="autobuffer"><source src="data:audio/ogg;base64,${parsed.audioAnimal} "/></audio>`;

	logoImg.style.background = `url("data:image/png;base64,${parsed.logoCategory}")`;
	logoImg.style.backgroundSize = `cover`;
	logoImg.style.backgroundRepeat = 'no-repeat';
	animalName.innerText = `${parsed.nameAnimal}`;
	categoryName.innerText = `${parsed.nameCategory}`;
	imgAnimal.style.background = `url("data:image/png;base64,${parsed.imageAnimal}")`;
	imgAnimal.style.backgroundSize = `cover`;
	imgAnimal.style.backgroundRepeat = 'no-repeat';

	if (audioControls !== null) {
		audioControls.remove();
	}
	wrapperAudio.insertAdjacentHTML('beforeend', audio);
	spinner.classList.remove('active');
}
