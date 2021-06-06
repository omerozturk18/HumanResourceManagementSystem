import React from 'react'
import ResumeList from '../../pages/ResumeList'
import ResumeDetail from '../../pages/ResumeDetail'
import Ablity from './Ablity'
import ForeignLanguage from './ForeignLanguage'
import School from './School'
import WorkExperience from './WorkExperience'

export default function Resume() {
    return (
        <div>
            <ResumeList/>
            <ResumeDetail/>
            <Ablity/>
            <ForeignLanguage/>
            <School/>
            <WorkExperience/>
        </div>
    )
}
