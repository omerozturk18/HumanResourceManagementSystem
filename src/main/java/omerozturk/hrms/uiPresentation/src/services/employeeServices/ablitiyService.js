import axios from "axios";

export default class AbilityService {
    getAbilityByEmployeeId(id) {
        return axios.get("http://localhost:8080/api/abilities/getAllByResumeEmployeeId?employeeId=" + id);
    }
    add(id) {
        return axios.post('http://localhost:8080/api/abilities/add', { abilityName: "string", resumeId: 1, technologyName: "string" })
            .then(function (response) { console.log(response); })
            .catch(function (error) {
                console.log(error);
            });
    }
}