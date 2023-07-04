$(document).ready(function () {
    $(document).on('keyup', '.customer-input', () => {
        const contentName = $("#name").val().trim();
        const contentPhone = $("#phone").val().trim();
        const contentAddress = $("#address").val().trim();
        const productCart = $(".cart-item-render");
        $('#pay').prop('disabled',
            contentName === ''||contentPhone === "" ||contentAddress === ''||productCart.val() === undefined);
    });
})