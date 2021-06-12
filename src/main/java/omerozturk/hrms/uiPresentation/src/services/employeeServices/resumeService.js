import axios from "axios";

export default class ResumeService {
    getAll() {
        return axios.get("http://localhost:8080/api/resumes/getall");
    }
    getByEmployeeId(id) {
        return axios.get("http://localhost:8080/api/resumes/getByEmployeeForResume?employeeId=" + id);
    }

    add(resume) {
        return axios.post('http://localhost:8080/api/resumes/add', resume)
            .then(function (response) { console.log(response); })
            .catch(function (error) {
                console.log(error);
            });
    }
}