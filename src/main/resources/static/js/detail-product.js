$(function () {

    $('#choose-image').change(function () {
        let img = document.getElementById('image-show')
        let input = document.getElementById('choose-image')

        if (input.files[0])
            img.src = URL.createObjectURL(input.files[0])
    })

    function encodeImageAsURL(element) {
        let file = element.files[0]
        let reader = new FileReader()
        reader.readAsDataURL(file)
        reader.onloadend = function () {
            console.log('RESULT', reader.result)
        }
    }

    let image = '0000000000000000000000000000000'

    $('#choose-image').change(function () {
        let file = this.files[0]
        let reader = new FileReader()
        reader.readAsDataURL(file)
        reader.onloadend = function () {
            image = reader.result
            console.log(image)
        }
    })


    $('#button-submit').click(function () {

        // let formData = new FormData()
        // let fileUpload = $('#choose-image')[0]
        // formData.append('file', fileUpload.files[0])

        const obj = {
            id: $('#product-id').text(),
            name: $('#product-name').val(),
            price: $('#product-price').val(),
            originalPrice: $('#product-original-price').val(),
            description: $('#product-description').text(),
            size36: $('#quan-size36').val(),
            size37: $('#quan-size37').val(),
            size38: $('#quan-size38').val(),
            size39: $('#quan-size39').val(),
            size40: $('#quan-size40').val(),
            size41: $('#quan-size41').val(),
            size42: $('#quan-size42').val(),
            size43: $('#quan-size43').val(),
            image: image.toString()
        }
        console.log(obj.image.slice(0, 10))
        $.post(
            "http://localhost:8080/edit-information",
            obj,
            function (data, status) {
                console.log('this is status: ' + status)
                console.log('this is data: ' + data)
                window.location.reload()
            }
        )
        // $.ajax(
        //     "http://localhost:8080/edit-information",
        //     {
        //         enctype: 'multipart/form-data',
        //         type: 'POST',
        //         processData: false,
        //         contentType: false,
        //         data: formData,
        //         cache: false,
        //         success: function(data, textStatus, jqXHR) {
        //             console.log('success')
        //         },
        //         error: function(jqXHR, textStatus, errorThrown) {
        //             console.log(jqXHR.toString())
        //
        //         }
        //     }
        // )
    })
})