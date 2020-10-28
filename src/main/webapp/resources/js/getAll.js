import modal from './modal.js';

const arrowRight = document.querySelector('.arrow_right');
const arrowLeft = document.querySelector('.arrow_left');
const arrowRightCategory = document.querySelector('.arrow_right_Category');
const arrowLeftCategory = document.querySelector('.arrow_left_Category');
const wrapperAnimalAll = Array.from(document.querySelectorAll('.animal'));
const wrapperCategorylAll = Array.from(document.querySelectorAll('.category'));
const spinner = document.querySelector('.spinner');

modal();

// смещение всех карточек направо. и отрисовка
function rendering(wrapperAll, arrowR, arrowL) {
	let count = -100;
	wrapperAll.forEach((item, idx) => {
		wrapperAll[idx].style.left = `${count + 100}%`;
		count += 100;
		item.classList.remove('active');
	});
	arrowL.classList.remove('hidden');
	arrowR.classList.remove('hidden');
}

// если карточка одна то деактивировать кнопки слайдера
function check(wrapperAll, arrowR, arrowL) {
	if (wrapperAll.length < 2) {
		arrowR.classList.add('deactive');
		arrowL.classList.add('deactive');
	} else {
		arrowL.classList.add('deactive');
	}
}

// слайдер, кнопка вправо - общая, на животное и на категорию
function sliderRight(wrapperAll, arrowR, arrowL) {
	const lastElement = wrapperAll[wrapperAll.length - 1];

	// если всего одно животное/категория, что бы не активировать кнопку переключения
	if (wrapperAll.length > 1) {
		arrowL.classList.remove('deactive');
	}

	if (lastElement.style.left !== '0%') {
		wrapperAll.forEach((item, idx) => {
			const styleLeft = wrapperAll[idx].style.left.slice(0, wrapperAll[idx].style.left.indexOf('%'));
			wrapperAll[idx].style.left = `${styleLeft - 100}%`;
		});
		if (lastElement.style.left === '0%') {
			arrowR.classList.add('deactive');
		}
	}
}

// слайдер, кнопка ввлево - общая, на животное и на категорию
function sliderLeft(wrapperAll, arrowR, arrowL) {
	const firstElement = wrapperAll[0];

	//если всего одно животное/категория, что бы не активировать кнопку переключения
	if (wrapperAll.length > 1) {
		arrowR.classList.remove('deactive');
	}

	if (firstElement.style.left !== '0%') {
		wrapperAll.forEach((item, idx) => {
			const styleLeft = +wrapperAll[idx].style.left.slice(0, wrapperAll[idx].style.left.indexOf('%'));
			wrapperAll[idx].style.left = `${styleLeft + 100}%`;
		});
		if (firstElement.style.left === '0%') {
			arrowL.classList.add('deactive');
		}
	}
}

rendering(wrapperAnimalAll, arrowRight, arrowLeft);
rendering(wrapperCategorylAll, arrowRightCategory, arrowLeftCategory);
check(wrapperAnimalAll, arrowRight, arrowLeft);
check(wrapperCategorylAll, arrowRightCategory, arrowLeftCategory);
spinner.classList.remove('active');

//  ------------------------  slider animal  --------------------------------------
//  ---  arrow right  ---

arrowRight.addEventListener('click', () => {
	sliderRight(wrapperAnimalAll, arrowRight, arrowLeft);
});

//  ---  arrow left  ---
arrowLeft.addEventListener('click', () => {
	sliderLeft(wrapperAnimalAll, arrowRight, arrowLeft);
});

//  ------------------------  slider category  --------------------------------------
//  ---  arrow right  ---

arrowRightCategory.addEventListener('click', () => {
	sliderRight(wrapperCategorylAll, arrowRightCategory, arrowLeftCategory);
});

//  ---  arrow left  ---
arrowLeftCategory.addEventListener('click', () => {
	sliderLeft(wrapperCategorylAll, arrowRightCategory, arrowLeftCategory);
});
