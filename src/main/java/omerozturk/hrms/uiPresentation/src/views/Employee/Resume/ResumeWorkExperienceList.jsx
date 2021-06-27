import React, { useState, useEffect } from 'react'
import WorkExperienceService from 'services/employeeServices/workExperienceService';
import Popup from 'reactjs-popup';
import HrmsTextInput from 'utilities/customForControls/HrmsTextInput';
import { Formik, Form } from 'formik';
import * as Yup from 'yup';

export default function ResumeWorkExperienceList({ ...props }) {
    const [workExperiences, setWorkExperience] = useState([]);
    useEffect(() => {
        let workExperienceService = new WorkExperienceService()
        workExperienceService.getAllByBusinessDate(props.resumeId).then(result => setWorkExperience(result.data.data))
    }, [])
    return (
        <div

            className={
                "relative flex flex-col min-w-0 break-words w-full mb-6 shadow-lg rounded " +
                (props.color === "light" ? "bg-white" : "bg-lightBlue-900 text-white")
            }
        >
            <div className="rounded-t mb-0 px-4 py-3 border-0">
                <div className="flex flex-wrap items-center">
                    <div className="relative w-full px-4 max-w-full flex-grow flex-1">
                        <h3
                            className={
                                "font-semibold text-lg " +
                                (props.color === "light" ? "text-blueGray-700" : "text-white")
                            }
                        >
                            İş/Staj Tecrübeleri
                        </h3>
                    </div>
                </div>
            </div>
            <div className="block w-full overflow-x-auto">
                {/* Projects table */}
                <table className="items-center w-full bg-transparent border-collapse">
                    <thead>
                        <tr>
                            <th
                                className={
                                    "px-6 align-middle border border-solid py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-left " +
                                    (props.color === "light"
                                        ? "bg-blueGray-50 text-blueGray-500 border-blueGray-100"
                                        : "bg-lightBlue-800 text-lightBlue-300 border-lightBlue-700")
                                }
                            >
                                İşyeri

                            </th>
                            <th
                                className={
                                    "px-6 align-middle border border-solid py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-left " +
                                    (props.color === "light"
                                        ? "bg-blueGray-50 text-blueGray-500 border-blueGray-100"
                                        : "bg-lightBlue-800 text-lightBlue-300 border-lightBlue-700")
                                }
                            >
                                İş Pozisyonu
                            </th>
                            <th
                                className={
                                    "px-6 align-middle border border-solid py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-left " +
                                    (props.color === "light"
                                        ? "bg-blueGray-50 text-blueGray-500 border-blueGray-100"
                                        : "bg-lightBlue-800 text-lightBlue-300 border-lightBlue-700")
                                }
                            >
                                Başlangıç Tarihi
                            </th>
                            <th
                                className={
                                    "px-6 align-middle border border-solid py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-left " +
                                    (props.color === "light"
                                        ? "bg-blueGray-50 text-blueGray-500 border-blueGray-100"
                                        : "bg-lightBlue-800 text-lightBlue-300 border-lightBlue-700")
                                }
                            >
                                Ayrılış Tarihi
                            </th>
                            <th
                                className={
                                    "px-6 align-middle border border-solid py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-left " +
                                    (props.color === "light"
                                        ? "bg-blueGray-50 text-blueGray-500 border-blueGray-100"
                                        : "bg-lightBlue-800 text-lightBlue-300 border-lightBlue-700")
                                }
                            >
                            </th>
                        </tr>
                    </thead>
                    {
                        workExperiences.map(workExperience => (
                            <tr key={workExperience.id}>
                                <th className="border-t-0 px-6 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4 text-left flex items-center">
                                    <span
                                        className={
                                            "ml-3 font-bold " +
                                            +(props.color === "light" ? "text-blueGray-600" : "text-white")
                                        }
                                    >
                                        {workExperience.workPlaceName}
                                    </span>
                                </th>
                                <td className="border-t-0 px-6 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4">
                                    {workExperience.jobPosition}
                                </td>
                                <td className="border-t-0 px-6 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4">
                                    <i className="fas fa-circle text-green-100 mr-2"></i> {workExperience.dateOfStart}
                                </td>
                                <td className="border-t-0 px-6 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4">
                                    <i className="fas fa-circle text-red-600 mr-2"></i>
                                    {workExperience.departureDate == null ? 'Devam Ediyor' : workExperience.departureDate}
                                </td>
                                <td className="border-t-0 border-l-0 border-r-0 text-xs whitespace-nowrap">
                                    {Modal(workExperience.workPlaceName,workExperience.jobPosition,workExperience.dateOfStart,workExperience.departureDate)}
                                </td>
                            </tr>
                        ))
                    }
                </table>
            </div>
        </div>
    )
}
const Modal = (workPlaceName, jobPosition, dateOfStart, departureDate) => {
    const validationSchema = Yup.object({
        workPlaceName: Yup.string().required("İşyeri İsmi Zorunludur"),
        jobPosition: Yup.string().required('Pozisyon İsmi Zorunludur'),
        dateOfStart: Yup.date().required("'İş Başlangıç Tarihi Zorunludur"),
    });
    let initialValues = {
        workPlaceName: workPlaceName,
        jobPosition: jobPosition,
        dateOfStart: dateOfStart,
        departureDate: departureDate
    };
    return (
        <div>
            <Popup
                trigger={<button className="bg-pink-500 text-white active:bg-pink-600 font-bold uppercase text-xs px-2 py-2 rounded shadow hover:shadow-lg outline-none focus:outline-none mr-1 mb-1 ease-linear transition-all duration-150"
                    type="button"> Düzenle</button>}
                modal
                nested
            >
                {close => (
                    <div className="modal">
                        <h6 className="text-blueGray-600 text-xl text-center mt-3 font-bold ">
                            İş/Staj Tecrübesi Düzenleme Ekranı
                        </h6>
                        <div className="content">
                            <Formik
                                initialValues={initialValues}
                                validationSchema={validationSchema}
                                onSubmit={(values) => {
                                    console.log(values)
                                }}>
                                <Form className="ui form">
                                    <hr className="mt-4 border-b-1 border-blueGray-300" />

                                    <h6 className="text-blueGray-400 text-md py-3 font-bold ">
                                    İş/Staj Tecrübesi Bilgileri
                                    </h6>
                                    <div className="flex flex-wrap">
                                        <div className="w-full lg:w-12/12 px-4">
                                            <div className="relative w-full mb-3">
                                                <HrmsTextInput type="text" name="workPlaceName" placeholder='İşyeri İsmi' />
                                            </div>
                                        </div>
                                        <div className="w-full lg:w-12/12 px-4">
                                            <div className="relative w-full mb-3">
                                                <HrmsTextInput type="text" name="jobPosition" placeholder='İş Pozisyonu İsmi' />
                                            </div>
                                        </div>
                                        <div className="w-full lg:w-12/12 px-4">
                                            <div className="relative w-full mb-3">
                                                <HrmsTextInput type="date" name="dateOfStart" placeholder='İş Başlangıç Tarihi' />
                                            </div>
                                        </div>
                                        <div className="w-full lg:w-12/12 px-4">
                                            <div className="relative w-full mb-3">
                                                <HrmsTextInput type="date" name="departureDate" placeholder='İş Bitiş Tarihi' />
                                            </div>
                                        </div>
                                    </div>
                                    <hr className="mt-4 border-b-1 border-blueGray-300" />
                                    <div className="flex flex-wrap pt-2">
                                        <div className="w-full lg:w-8/12 ">
                                        </div>
                                        <div className="w-full lg:w-4/12 pl-4">
                                            <div className="relative w-full">
                                                <button className=" bg-green text-white active:bg-pink-600 font-bold uppercase text-xs px-4 py-3 rounded shadow hover:shadow-lg outline-none focus:outline-none mr-1 mb-1 ease-linear transition-all duration-150"
                                                    type="submit"><i className="fas fa-save"></i>  Kaydet</button>
                                                <button className=" bg-red-600 text-white active:bg-red-400 font-bold uppercase text-xs px-4 py-3 rounded shadow hover:shadow-lg outline-none focus:outline-none mr-1 mb-1 ease-linear transition-all duration-150"
                                                    type="button" onClick={close}>
                                                    <i className="fas fa-ban"></i> İptal</button>
                                            </div>
                                        </div>
                                    </div>
                                </Form>
                            </Formik>

                        </div>
                    </div>
                )}
            </Popup>
        </div>
    )
}