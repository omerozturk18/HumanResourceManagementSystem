import React, { useState, useEffect } from 'react'
import ResumeService from 'services/employeeServices/resumeService';

export default function ResumeList() {
    const [resumes, setAll] = useState([]);

    useEffect(() => {
        let resumeService = new ResumeService()
        resumeService.getAll().then(result => setAll(result.data.data))
    }, [])

    return (
        <div>

        </div>
    )
}
