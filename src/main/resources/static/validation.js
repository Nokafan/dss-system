import notification from "./notification.js";
export const validation = form => {
    let success = true
    $('.type-error').remove()
    $(form).find('input').each((i, el) => {
        if($(el).data('validate') == 'email') {
            const regex = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/
            if(!regex.test($(el).val())) {
                $(el).parent().append(`<p class="type-error">required fild</p>`)
                success = false
            }
        }
        if($(el).data('validate') == 'password') {
            const regex = /(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*]{6,}/g
            if(!regex.test($(el).val())) {
                $(el).parent().append(`<p class="type-error">Password should be at least 6 characters and contain uppercase and lowercase letter, numbers.</p>`)
                success = false
            }
        }
        if($(el).data('validate') == 'password2') {
            if($(el).val() !== form.password.value) {
                $(el).parent().append(`<p class="type-error">Password mismatch</p>`)
                success = false
            }
        }

    })
    return success
}