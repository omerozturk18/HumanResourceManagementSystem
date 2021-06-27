import React, { useState, useEffect } from 'react'
import JobPostgingService from 'services/employerServices/jobPostingService';

export default function JobPostingDetail() {
    const [jobPosting, setJobPosting] = useState([])

    useEffect(() => {
        let jobPostingService = new JobPostgingService();
        jobPostingService.getByEmployerId(1).then(result => setJobPosting(result.data.data))
    }, [])
    return (
        <div>
         {console.log(jobPosting)}
        </div>
    )
}
