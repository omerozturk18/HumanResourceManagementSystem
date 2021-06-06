import axios from "axios";

export default class EmployeeImageService {
    getAll() {
        return axios.get("http://localhost:8080/api/employeeimages/getAll" );
    }
    getByEmployeeId(id) {
        return axios.get("http://localhost:8080/api/employeeimages/getAllByEmployeeId?employeeId=" + id);
    }

    addImageForEmployee(id, file) {
        return axios.post('http://localhost:8080/api/employeeimages/add?employeeId=' + id, file)
            .then(function (response) { console.log(response); })
            .catch(function (error) {
                console.log(error);
            });
    }

    addToUrlImage(image) {
        return axios.post('http://localhost:8080/api/employeeimages/addToUrlImage', image)
            .then(function (response) { console.log(response); })
            .catch(function (error) {
                console.log(error);
            });
    }
}