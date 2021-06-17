export default function (type, message) {
    const div = document.createElement('div')
    div.className = `notification-wrapper ${type}`
    div.innerHTML = `<p>${message}</p>`
    document.body.appendChild(div)
    const timer = setInterval(() => {
        $('.notification-wrapper').remove()
        clearInterval(timer)
    }, 5000)

}