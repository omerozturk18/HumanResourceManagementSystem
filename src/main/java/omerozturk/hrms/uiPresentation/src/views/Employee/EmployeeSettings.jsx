import React, { useState, useEffect } from 'react'
import EmployeeService from 'services/employeeServices/employeeService';
import { Formik, Form } from 'formik';
import * as Yup from 'yup';
import HrmsTextInput from 'utilities/customForControls/HrmsTextInput';
import Resume from './Resume/Resume';

export default function EmployeeSettings() {
  const [employee, setEmployee] = useState()

  useEffect(() => {
    let employeeService = new EmployeeService()
    employeeService.getByEmployeeId(1).then(result => setEmployee(result.data.data))
  }, [])

  if (employee !== undefined) {
    const validationSchema = Yup.object({
      firstName: Yup.string().required("İsim Zorunludur"),
      lastName: Yup.string().required("Soyisim Zorunludur"),
      email: Yup.string().email("Geçerli Bir Eposta Giriniz").required('Eposta Zorunludur'),
      birthDate: Yup.date().required('Doğum Tarihi Zorunludur'),
    });
    let initialValues = {
      firstName: employee.firstName,
      lastName: employee.lastName,
      email: employee.email,
      birthDate: employee.birthDate,
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
                  Kullanıcı Bilgileri
                </h6>
                <div className="flex flex-wrap">
                  <div className="w-full lg:w-6/12 px-4">
                    <div className="relative w-full mb-3">
                      <HrmsTextInput type="text" name="firstName" placeholder='İsim' disabled/>
                    </div>
                  </div>
                  <div className="w-full lg:w-6/12 px-4">
                    <div className="relative w-full mb-3">
                      <HrmsTextInput type="text" name="lastName" placeholder='Soyisim' disabled />
                    </div>
                  </div>
                  <div className="w-full lg:w-6/12 px-4">
                    <div className="relative w-full mb-3">
                      <HrmsTextInput type="email" name="email" placeholder='Eposta' disabled/>
                    </div>
                  </div>
                  <div className="w-full lg:w-6/12 px-4">
                    <div className="relative w-full mb-3">
                      <HrmsTextInput type="date" name="birthDate" placeholder='Doğum Tarihi' disabled/>
                      <div className="relative w-full mb-3">
                      </div>
                    </div>
                  </div>
                </div>
              </Form>
            </Formik>
            <Resume employeeId={employee.id} />
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
