import axios from "axios";

export default class JobPostgingService {
    getActiveJobPostgings(){
        return axios.get("http://localhost:8080/api/jobPosting/getByActive");
    }
}