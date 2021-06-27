import React, { useState, useEffect } from 'react'
import { Formik, Form } from 'formik';
import * as Yup from 'yup';
import HrmsTextInput from 'utilities/customForControls/HrmsTextInput';
import SystemUserService from 'services/systemServices/systemUserService';

export default function SystemUserEdit() {
    const [systemUser, setSystemUser] = useState()

    useEffect(() => {
        let systemUserService = new SystemUserService()
        systemUserService.getById(3).then(result => setSystemUser(result.data.data))
    }, [])

    if (systemUser !== undefined) {
        const validationSchema = Yup.object({
            firstName: Yup.string().required("İsim Zorunludur"),
            lastName: Yup.string().required("Soyisim Zorunludur"),
            email: Yup.string().email("Geçerli Bir Eposta Giriniz").required('Eposta Zorunludur'),
        });
        let initialValues = {
            firstName: systemUser.firstName,
            lastName: systemUser.lastName,
            email: systemUser.email,
            roles: systemUser.roles,
        };
        return (
            <div>

                <div className="relative flex flex-col min-w-0 break-words w-full mb-6 shadow-lg rounded-lg bg-blueGray-100 border-0">
                    <div className="rounded-t bg-white mb-0 px-6 py-6">
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
                                    Sistem Kullanıcı Bilgileri
                                </h6>
                                <div className="flex flex-wrap">
                                    <div className="w-full lg:w-6/12 px-4">
                                        <div className="relative w-full mb-3">
                                            <HrmsTextInput type="text" name="firstName" placeholder='İsim' />
                                        </div>
                                    </div>
                                    <div className="w-full lg:w-6/12 px-4">
                                        <div className="relative w-full mb-3">
                                            <HrmsTextInput type="text" name="lastName" placeholder='Soyisim' />
                                        </div>
                                    </div>
                                    <div className="w-full lg:w-6/12 px-4">
                                        <div className="relative w-full mb-3">
                                            <HrmsTextInput type="email" name="email" placeholder='Eposta' />
                                        </div>
                                    </div>
                                    <div className="w-full lg:w-6/12 px-4">
                                        <div className="relative w-full mb-3">
                                            <HrmsTextInput type="text" name="roles" placeholder='Kullanıcı Rolü' disabled/>
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
                                                <button className=" bg-red-600 text-white active:bg-pink-600 font-bold uppercase text-xs px-6 py-3 rounded shadow hover:shadow-lg outline-none focus:outline-none mr-1 mb-1 ease-linear transition-all duration-150"
                                                type="button"><i className="fas fa-save"></i>  Şifre Yenile</button>
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
