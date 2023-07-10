$(document).ready(function () {
    let count = 0
    $('.check-out').click(function () {
        // ++count
        // console.log(count)
        // let data1 = new Object()
        // data1.billCode = this.name
        // data1.confirm = this.value
        // $.ajax({
        //     url: 'http://localhost:8080/change-status-order',
        //     type: 'POST',
        //     dataType: 'application/json',
        //     data: data1,
        //     success: function (data, textStatus, xhr) {
        //         console.log(data);
        //     },
        //     error: function (xhr, textStatus, errorThrown) {
        //         console.log('Error in Operation');
        //     }
        // })
        $.post(
            'http://localhost:8080/change-status-order',
            {
                billCode: this.name,
                confirm: this.value
            },function (data,status){
                console.log(status)
            }
        )
        if (this.value === 'Confirm'){
            this.value = 'Undo'
            this.style.background = 'red'
        } else {
            this.value = 'Confirm'
            this.style.background = '#2FBE70'
        }
    })
})