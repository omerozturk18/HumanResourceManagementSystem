import React, { useState, useEffect } from 'react'
import ResumeService from 'services/employeeServices/resumeService';

export default function ResumeDetail() {
    const [resume, setByEmployeeId] = useState([]);

    useEffect(() => {
        let resumeService = new ResumeService()
        resumeService.getByEmployeeId(1).then(result => setByEmployeeId(result.data.data))
    }, [])

    return (
        <div>
           
        </div>
    )
}
