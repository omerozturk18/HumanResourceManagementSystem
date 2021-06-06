import React, { useState,useEffect } from 'react'
import { Icon, Menu, Table } from 'semantic-ui-react'
import JobPostgingService from '../services/employerServices/jobPostingService';

export default function JobPostgingList() {
    const [jobPostgings, setActiveJobPostgings] = useState([]);

    useEffect(() => {
        let jobPostingService=new JobPostgingService()
        jobPostingService.getActiveJobPostgings().then(result=>setActiveJobPostgings(result.data.data))
    },[])

    return (
        <div>
            <Table celled>
                <Table.Header>
                    <Table.Row>
                        <Table.HeaderCell>Firma İsmi</Table.HeaderCell>
                        <Table.HeaderCell>İş Pozisyonu</Table.HeaderCell>
                        <Table.HeaderCell>İş Açıklaması</Table.HeaderCell>
                        <Table.HeaderCell>Min-Max Ucret</Table.HeaderCell>
                        <Table.HeaderCell>Pozisyon Sayısı</Table.HeaderCell>
                        <Table.HeaderCell>Son Başvuru Tarihi</Table.HeaderCell>
                    </Table.Row>
                </Table.Header>

                <Table.Body>
                    {
                        jobPostgings.map(jobPostging => (
                            <Table.Row key={jobPostging.id}>
                                <Table.Cell>{jobPostging.employer.companyName}</Table.Cell>
                                <Table.Cell>{jobPostging.jobPosition.positionName}</Table.Cell>
                                <Table.Cell>{jobPostging.jobDescription}</Table.Cell>
                                <Table.Cell>{jobPostging.minSalary}-{jobPostging.maxSalary}</Table.Cell>
                                <Table.Cell>{jobPostging.openPositionCount}</Table.Cell>
                                <Table.Cell>{jobPostging.applicationDeadline}</Table.Cell>
                            </Table.Row>
                        ))
                    }

                </Table.Body>

                <Table.Footer>
                    <Table.Row>
                        <Table.HeaderCell colSpan='6'>
                            <Menu floated='right' pagination>
                                <Menu.Item as='a' icon>
                                    <Icon name='chevron left' />
                                </Menu.Item>
                                <Menu.Item as='a'>1</Menu.Item>
                                <Menu.Item as='a'>2</Menu.Item>
                                <Menu.Item as='a'>3</Menu.Item>
                                <Menu.Item as='a'>4</Menu.Item>
                                <Menu.Item as='a' icon>
                                    <Icon name='chevron right' />
                                </Menu.Item>
                            </Menu>
                        </Table.HeaderCell>
                    </Table.Row>
                </Table.Footer>
            </Table>
        </div>
    )
}
