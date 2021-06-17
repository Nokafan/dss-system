
class Api {
    login(data) {
        return axios.post('/api/user/login', data)
    }
    register(data) {
        return axios.post('/api/user/registration', data)
    }

}
export default new Api()