import React, { useState, useEffect } from 'react'
import { Icon, Menu, Table } from 'semantic-ui-react'
import ResumeService from '../services/employeeServices/resumeService';

export default function ResumeDetail() {
    const [resume, setByEmployeeId] = useState([]);

    useEffect(() => {
        let resumeService = new ResumeService()
        resumeService.getByEmployeeId(1).then(result => setByEmployeeId(result.data.data))
    }, [])

    return (
        <div>
            <Table celled>
                <Table.Header>
                    <Table.Row>
                        <Table.HeaderCell>Açıklama</Table.HeaderCell>
                        <Table.HeaderCell>GitHub</Table.HeaderCell>
                        <Table.HeaderCell>Linkedin</Table.HeaderCell>
                    </Table.Row>
                </Table.Header>

                <Table.Body>
                    {

                        <Table.Row key={resume.id}>
                            <Table.Cell>{resume.description}</Table.Cell>
                            <Table.Cell>{resume.githubAddress}</Table.Cell>
                            <Table.Cell>{resume.linkedinAddress}</Table.Cell>
                        </Table.Row>

                    }

                </Table.Body>

                <Table.Footer>
                    <Table.Row>
                        <Table.HeaderCell colSpan='4'>
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
