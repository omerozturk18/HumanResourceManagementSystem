import React, { useState, useEffect } from 'react'
import ForeignLanguageService from 'services/employeeServices/foreignLanguageService';
import Popup from 'reactjs-popup';
import HrmsTextInput from 'utilities/customForControls/HrmsTextInput';
import { Formik, Form } from 'formik';
import * as Yup from 'yup';

export default function ResumeForeignLanguageList({ ...props }) {
    const [foreignLanguages, setForeignLanguage] = useState([]);

    useEffect(() => {
        let foreignLanguageService = new ForeignLanguageService()
        foreignLanguageService.getAllByResumeId(1).then(result => setForeignLanguage(result.data.data))
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
                            Yabancı Dil Bilgisi
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
                                Yabancı Dil

                            </th>
                            <th
                                className={
                                    "px-6 align-middle border border-solid py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-left " +
                                    (props.color === "light"
                                        ? "bg-blueGray-50 text-blueGray-500 border-blueGray-100"
                                        : "bg-lightBlue-800 text-lightBlue-300 border-lightBlue-700")
                                }
                            >
                                Yabancı Dil Seviyesi
                            </th>
                            <th className={
                                "px-6 align-middle border border-solid py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-left " +
                                (props.color === "light"
                                    ? "bg-blueGray-50 text-blueGray-500 border-blueGray-100"
                                    : "bg-lightBlue-800 text-lightBlue-300 border-lightBlue-700")
                            }
                            ></th>
                        </tr>
                    </thead>
                    {
                        foreignLanguages.map(foreignLanguage => (
                            <tr key={foreignLanguage.id}>
                                <th className="border-t-0 px-6 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4 text-left flex items-center">
                                    <span
                                        className={
                                            "ml-3 font-bold " +
                                            +(props.color === "light" ? "text-blueGray-600" : "text-white")
                                        }
                                    >
                                        {foreignLanguage.languageName}
                                    </span>
                                </th>
                                <td className="border-t-0 px-6 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4">
                                    <div className="flex items-center">
                                        <span className="mr-2">{foreignLanguage.languageLevel}</span>
                                        <div className="relative w-full">
                                            <div className="overflow-hidden h-2 text-xs flex rounded bg-emerald-200">
                                                <div
                                                    style={{ width: foreignLanguage.languageLevel + "%" }}
                                                    className={"shadow-none flex flex-col text-center whitespace-nowrap text-white justify-center " + (foreignLanguage.languageLevel > 70 ? "bg-emerald-500" : "bg-red-500")}
                                                ></div>
                                            </div>
                                        </div>
                                    </div>
                                </td>
                                <td className="border-t-0 border-l-0 border-r-0 text-xs whitespace-nowrap">
                                    {Modal(foreignLanguage.languageName, foreignLanguage.languageLevel)}
                                </td>
                            </tr>
                        ))
                    }
                </table>
            </div>
        </div>
    )
}

const Modal = (languageName, languageLevel) => {
    const validationSchema = Yup.object({
        languageName: Yup.string().required("Yabancı Dil İsmi Zorunludur"),
        languageLevel: Yup.string().required('Yabancı Dil Seviyesi Zorunludur'),
    });
    let initialValues = {
        languageName: languageName,
        languageLevel: languageLevel
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
                        <h1 className="text-blueGray-600 text-xl text-center mt-3 font-bold ">
                            Yabancı Dil Düzenleme Ekranı
                        </h1>
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
                                        Yabancı Dil Bilgileri
                                    </h6>
                                    <div className="flex flex-wrap">
                                        <div className="w-full lg:w-12/12 px-4">
                                            <div className="relative w-full mb-3">
                                                <HrmsTextInput type="text" name="languageName" placeholder='Yabancı Dil İsmi' />
                                            </div>
                                        </div>
                                        <div className="w-full lg:w-12/12 px-4">
                                            <div className="relative w-full mb-3">
                                                <HrmsTextInput type="text" name="languageLevel" placeholder='Yabancı Dil Seviyesi' />
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