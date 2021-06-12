import axios from "axios";

export default class JobPostgingService {
    getActiveJobPostgings() {
        return axios.get("http://localhost:8080/api/jobPosting/getByActive");
    }
    getByEmployerId(id) {
        return axios.get("http://localhost:8080/api/jobPosting/getByEmployer?employerId=" + id);
    }

    add(jobPosting) {
        return axios.post('http://localhost:8080/api/jobPosting/add', jobPosting)
            .then(function (response) { console.log(response); })
            .catch(function (error) {
                console.log(error);
            });
    }
    changeStatus(id) {
        return axios.get("http://localhost:8080/api/jobPosting/changeStatus?jobPostingId=" + id);
    }
    getByReleaseDate(orderBy) {
        return axios.get("http://localhost:8080/api/jobPosting/getByReleaseDate?value=" + orderBy);
        //Desc için '0' gönderin 
    }
}