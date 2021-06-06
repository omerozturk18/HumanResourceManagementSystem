import React, { useState, useEffect } from 'react'
import JobPostgingService from '../services/employerServices/jobPostingService';
import { Card, Icon } from 'semantic-ui-react'
export default function JobPostgingList() {
    const [jobPostgings, setActiveJobPostgings] = useState([]);

    useEffect(() => {
        let jobPostingService = new JobPostgingService()
        jobPostingService.getActiveJobPostgings().then(result => setActiveJobPostgings(result.data.data))
    }, [])

    return (
        <div>
            {
             jobPostgings.map(jobPostging => (
            
                <Card>
                    <Card.Content header={jobPostging.jobPosition.positionName} />
                    <Card.Content>
                    Firma: {jobPostging.employer.companyName}
                    </Card.Content>
                    <Card.Content description={jobPostging.jobDescription} />
                    <Card.Content extra>
                        Son Başvuru Tarihi: {jobPostging.applicationDeadline}
                    </Card.Content>
                </Card>

             ))
}
        </div >
    )
}
