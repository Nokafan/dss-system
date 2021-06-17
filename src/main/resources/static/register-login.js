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