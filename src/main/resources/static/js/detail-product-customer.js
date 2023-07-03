// const imgs = document.querySelectorAll('.img-select a');
// const imgBtns = [...imgs];
// let imgId = 1;
//
// imgBtns.forEach((imgItem) => {
//     imgItem.addEventListener('click', (event) => {
//         event.preventDefault();
//         imgId = imgItem.dataset.id;
//         slideImage();
//     });
// });
//
// function slideImage(){
//     const displayWidth = document.querySelector('.img-showcase img:first-child').clientWidth;
//
//     document.querySelector('.img-showcase').style.transform = `translateX(${- (imgId - 1) * displayWidth}px)`;
// }
//
// window.addEventListener('resize', slideImage);
// $(document).ready(function(){
//     $('#red').on('click', function (){
//         alert('Nguyen Duy Anh Tuan')
//     })
// });
//https://www.baeldung.com/thymeleaf-js-function-call
function sizeClick(size) {
    let sizeSelectedInput = document.getElementById('size-selected-input')
    sizeSelectedInput.value = size
}
