const qr = document.querySelector('.qr');
const qr_Code = document.querySelector('.qr_Code');

qr_Code.addEventListener('click', (ev) => {
    if (ev.target === qr_Code) {
        qr_Code.classList.remove('active');
        qr.classList.remove('active');
        blur();
    } else {
        qr_Code.classList.toggle('active');
        qr.classList.toggle('active');
        blur();
    }
});

function blur(){
    const headerIndex = document.querySelector('.header.index');
    const pageStart = document.querySelector('.page.start');
    const pageLogin = document.querySelector('.page.login');
    headerIndex.classList.toggle('blur');
    pageStart.classList.toggle('blur');
    pageLogin.classList.toggle('blur');
}
