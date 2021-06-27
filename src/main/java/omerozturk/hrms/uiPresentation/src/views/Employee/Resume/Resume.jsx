import React, { useState, useEffect } from 'react'
import ResumeSchoolList from './ResumeSchoolList';
import ResumeWorkExperienceList from './ResumeWorkExperienceList';
import ResumeForeignLanguageList from './ResumeForeignLanguageList';
import { Formik, Form } from 'formik';
import * as Yup from 'yup';
import HrmsTextInput from 'utilities/customForControls/HrmsTextInput';
import HrmsLabel from 'utilities/customForControls/HrmsLabel';
import HrmsTextarea from 'utilities/customForControls/HrmsTextarea';
import ResumeService from 'services/employeeServices/resumeService';

export default function Resume({ ...props }) {
    const [resume, setResume] = useState();
    useEffect(() => {
        let resumeService = new ResumeService();
        resumeService.getByEmployeeIdAndDate(props.employeeId).then(result => setResume(result.data.data))
    }, []);
    if (resume !== undefined) {
        const validationSchema = Yup.object({
            description: Yup.string().required("Açıklama Zorunludur"),
            githubAddress: Yup.string().required("Github Adresi Zorunludur"),
            linkedinAddress: Yup.string().required('Linkedin Adresi Zorunludur'),
        });
        let initialValues = {
            description: resume.description,
            linkedinAddress: resume.linkedinAddress,
            githubAddress: resume.githubAddress
        };
        return (
            <div>


                <Formik
                    initialValues={initialValues}
                    validationSchema={validationSchema}
                    onSubmit={(values) => {
                        console.log(values)
                    }}>
                    <Form className="ui form">
                        <hr className="mt-6 border-b-1 border-blueGray-300" />

                        <h6 className="text-blueGray-400 text-sm mt-3 mb-6 font-bold ">
                            İletişim Bilgilerim
                        </h6>
                        <div className="flex flex-wrap">
                            <div className="w-full lg:w-12/12 px-4">
                                <div className="relative w-full mb-3">
                                    <HrmsTextInput type="text" name="githubAddress" placeholder='Github Adresi' />
                                </div>
                            </div>
                            <div className="w-full lg:w-12/12 px-4">
                                <div className="relative w-full mb-3">
                                    <HrmsTextInput type="text" name="linkedinAddress" placeholder='Linkedn Adresi' />
                                </div>
                            </div>
                            {/* <div className="w-full lg:w-12/12 px-4">
                  <div className="relative w-full mb-3">
                    <HrmsLabel value="Şehir" />
                    <HrmsSelectList name="cityId"
                      option={cities.map(city => { return <option value={city.id}>{city.name}</option> })} />
                  </div>
                </div> */}
                        </div>

                        <hr className="mt-6 border-b-1 border-blueGray-300" />

                        <h6 className="text-blueGray-400 text-sm mt-3 mb-6 font-bold ">
                            Hakkımda
                        </h6>

                        <div className="flex flex-wrap">
                            <div className="w-full lg:w-12/12 px-4">
                                <div className="relative w-full mb-3">
                                    <HrmsLabel value="Profil Yazısı" />
                                    <HrmsTextarea type="date" name="description" placeholder='Profil Yazısı' rows="5" value={resume.description} />
                                </div>
                            </div>
                        </div>
                        <div className="flex flex-wrap">
                            <div className="w-full lg:w-8/12 px-4">
                                <div className="relative w-full mb-3">
                                </div>
                            </div>
                            <div className="w-full lg:w-4/12 px-4">
                                <div className="relative w-full mb-3">
                                    <button className=" bg-green text-white active:bg-pink-600 font-bold uppercase text-xs px-6 py-3 rounded shadow hover:shadow-lg outline-none focus:outline-none mr-1 mb-1 ease-linear transition-all duration-150"
                                        type="submit"><i className="fas fa-save"></i>  Kaydet</button>
                                </div>
                            </div>
                        </div>
                    </Form>
                </Formik>
                <ResumeSchoolList resumeId={resume.id} color="" />
                <ResumeWorkExperienceList resumeId={resume.id} color="light" />
                <ResumeForeignLanguageList resumeId={resume.id} color="" />
            </div>
        )
    } else {
        return (<div></div>)
    }
}
