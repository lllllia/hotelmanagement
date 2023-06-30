$(document).ready(function() {
    sessionStorage.clear()
})

$(document).keypress((event) => {
    if (event.keyCode == 13) {
        login()
    }
})

// 清空登录信息
function clearLogin() {
    $("#empId").val('')
    $("#empPassword").val('')
}

// 登录
function login() {
    System.out.println("%%%");
    if ($("#user_id").val() == "" || $("#password").val() == "") {
        alert("账号及密码不可为空")
    } else {
        $.ajax({
            url: "/SIGNIN",
            type: "POST",
            data: {
                empId: $("#user_id").val(),
                empPassword: md5($("#password").val())
            },
            contentType: "application/x-www-form-urlencoded",
            dataType: "json",
            success: (data) => {
                if (data.user_id == "") {
                    alert("密码错误")
                } else {
                    //sessionStorage.setItem("empId", data.user_id)
                    //sessionStorage.setItem("empName", data.empName)
                    /*if (sessionStorage.getItem("user_id") == 'admin') {
                        window.location.href = "/adminPage"
                    } else {*/
                        // alert("登录成功！欢迎，" + sessionStorage.getItem("empName") + "!")
                        window.location.href = "/index.html"
                    //}
                }
            },
            error: (error) => {
                alert("发生错误")
                console.log(error)
            }
        })
    }
}