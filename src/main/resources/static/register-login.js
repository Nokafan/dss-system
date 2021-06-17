import Api from './Api.js'
import {validation} from "./validation.js";
import notification from "./notification.js";

$(document).on('submit', '#registerForm', function (e) {
    e.preventDefault()
    if(validation(this)) {
        const data = {
            email: this.email.value,
            password: this.password.value,
        }
        Api.register(data)
            .then(() => {
                $('.close').click()
                notification('success', 'Register success!')
            })
            .catch(() => notification('fail', 'Something went wrong'))
    }
})

$(document).on('submit', '#loginForm', function (e) {
    e.preventDefault()
    const data = {
        username: this.login.value,
        password: this.password.value
    }
    Api.login(data)
        .then(res => {
            localStorage.setItem('token', res.headers.authorization)
            axios.defaults.headers.common['Authorization'] = res.headers.authorization
            window.location.href = '/workspace.html'
        })
        .catch((e) => {
            console.log( e.message)
            notification('fail', 'Wrong login or password')
        })
})