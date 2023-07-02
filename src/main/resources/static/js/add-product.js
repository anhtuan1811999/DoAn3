function change() {
    let img = document.getElementById('show-img')
    let input = document.getElementById('product-image')
    if (input.files[0])
        img.src = URL.createObjectURL(input.files[0])
}


function check(id) {
    const checkbox = document.getElementById(id)
    const quantityInput = document.getElementById('quantity-' + id)
    if (checkbox.checked) {
        quantityInput.disabled = false
    } else {
        quantityInput.value = ''
        quantityInput.disabled = true
    }
}