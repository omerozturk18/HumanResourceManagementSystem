import React, { useState, useEffect } from 'react'
import { Formik, Form } from 'formik';
import * as Yup from 'yup';
import HrmsTextInput from 'utilities/customForControls/HrmsTextInput';
import EmployerService from 'services/employerServices/employerService';

export default function EmployerEdit() {
    const [employer, setEmployer] = useState()

    useEffect(() => {
        let employerService = new EmployerService()
        employerService.getByEmployerId(2).then(result => setEmployer(result.data.data))
    }, [])

    if (employer !== undefined) {
        const validationSchema = Yup.object({
            companyName: Yup.string().required("Firma İsmi Zorunludur"),
            webSite: Yup.string().required("Website Zorunludur"),
            email: Yup.string().email("Geçerli Bir Eposta Giriniz").required('Eposta Zorunludur'),
            phoneNumber: Yup.number().required('Telefon Numarası Zorunludur').min(0, "Eksi Değer Giremezsiniz"),
        });
        let initialValues = {
            companyName: employer.companyName,
            webSite: employer.webSite,
            email: employer.email,
            phoneNumber: employer.phoneNumber,
        };
        return (
            <div>

                <div className="relative flex flex-col min-w-0 break-words w-full mb-6 shadow-lg rounded-lg bg-blueGray-100 border-0">
                    <div className="rounded-t bg-white mb-0 px-6 py-6">
                        {employer.updateVerifiedBySystem === false ?
                            <div className="text-white px-6 py-4 border-0 rounded relative mb-4 bg-orange-500 ">
                                <span className="text-xl inline-block mr-5 align-middle">
                                    <i className="fas fa-bell"></i>
                                </span>
                                <span className="inline-block align-middle px-6">
                                    <b className="capitalize">Uyarı!</b><br></br>
                                    Yapmış Olduğunuz Değişiklikler Sistem Tarfaında Onaylandıktan Sonra Yansıyacaktır.
                                </span>
                            </div>:""
                            }
                        <div className="text-center flex justify-between">
                            <h6 className="text-blueGray-700 text-xl font-bold">Profilim</h6>
                        </div>
                    </div>
                    <div className="flex-auto px-4 lg:px-10 py-10 pt-0">

                        <Formik
                            initialValues={initialValues}
                            validationSchema={validationSchema}
                            onSubmit={(values) => {
                                console.log(values)
                            }}>
                            <Form className="ui form">
                                <h6 className="text-blueGray-400 text-sm mt-3 mb-6 font-bold ">
                                    Firma Bilgileri
                                </h6>
                                <div className="flex flex-wrap">
                                    <div className="w-full lg:w-6/12 px-4">
                                        <div className="relative w-full mb-3">
                                            <HrmsTextInput type="text" name="companyName" placeholder='Firma İsmi' />
                                        </div>
                                    </div>
                                    <div className="w-full lg:w-6/12 px-4">
                                        <div className="relative w-full mb-3">
                                            <HrmsTextInput type="text" name="webSite" placeholder='Website Adresi' />
                                        </div>
                                    </div>
                                    <div className="w-full lg:w-6/12 px-4">
                                        <div className="relative w-full mb-3">
                                            <HrmsTextInput type="email" name="email" placeholder='Eposta' />
                                        </div>
                                    </div>
                                    <div className="w-full lg:w-6/12 px-4">
                                        <div className="relative w-full mb-3">
                                            <HrmsTextInput type="number" name="phoneNumber" placeholder='Telefon Numarası' />
                                            <div className="relative w-full mb-3">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div className="flex flex-wrap pt-6">
                                    <div className="w-full lg:w-9/12 ">
                                        <div className="relative w-full">
                                        </div>
                                    </div>
                                    <div className="w-full lg:w-3/12 ">
                                        <div className="relative w-full">
                                            <button className=" bg-green text-white active:bg-pink-600 font-bold uppercase text-xs px-6 py-3 rounded shadow hover:shadow-lg outline-none focus:outline-none mr-1 mb-1 ease-linear transition-all duration-150"
                                                type="submit"><i className="fas fa-save"></i>  Kaydet</button>
                                        </div>
                                    </div>
                                </div>
                            </Form>
                        </Formik>
                    </div>
                </div>
            </div>
        )
    } else {
        return (
            <div></div>

        )
    }

}
