const close = document.querySelector('.close');
const modalJSP = document.querySelector('.modal');

export default function modal() {
	close.addEventListener('click', () => {
		add();
	});
	setTimeout(add, 30000);
}

function add() {
	modalJSP.classList.add('active');
}
