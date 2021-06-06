import axios from "axios";

export default class AuthService {
    login(login) {
        return axios.get("http://localhost:8080/api/auth/login" + login);
    }
    registerEmpoyee(employee) {
        return axios.post('http://localhost:8080/api/auth/registerForEmployee',
            {
                birthDate: "string",
                email: "string",
                firstName: "string",
                lastName: "string",
                nationalityIdent: "string",
                password: "string",
                verifyPassword: "string"
            })
            .then(function (response) { console.log(response); })
            .catch(function (error) {
                console.log(error);
            });
    }
    registerEmpoyer(employer) {
        return axios.post('http://localhost:8080/api/auth/registerForEmployee',employer)
            .then(function (response) { console.log(response); })
            .catch(function (error) {
                console.log(error);
            });
    }
}