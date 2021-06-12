
import React, { useState, useEffect } from 'react'
import Navbar from "components/Navbars/AuthNavbar.js";
import Footer from "components/Footers/Footer.js";
import CityService from 'services/systemServices/cityService';
import JobPositionService from 'services/systemServices/jobPositionService';
import { EnumWayOfWorking } from 'enums/EnumWayOfWorking';
import { EnumPlaceOfWorking } from 'enums/EnumPlaceOfWorking';
import JobPostgingService from 'services/employerServices/jobPostingService';
import { useFormik } from 'formik';
import * as Yup from 'yup';

export default function JobPostingDetail() {
    let postService = new JobPostgingService;

    const [cities, setCities] = useState([])
    const [positions, setPositions] = useState([])

    useEffect(() => {
        let cityService = new CityService();
        cityService.getCities().then(result => setCities(result.data.data))
        let positionService = new JobPositionService();
        positionService.getAll().then(result => setPositions(result.data.data))
    }, [])

    const validationSchema = Yup.object({
        description: Yup.string().required("Zorunlu alan"),
        positionId: Yup.string().required("Pozisyon Seçilmelidir"),
        wayOfWorkingId: Yup.string().required('Çalışma Şekli Seçilmelidir'),
        workingTimeId: Yup.string().required('Çalışma Zamanı Seçilmelidir'),
        positionCount: Yup.number().required('Pozisyon Sayısı Zorunludur'),
        minSalary: Yup.number().required('Metin girilemez!'),
        maxSalary: Yup.number().required('Metin girilemez!'),
        cityId: Yup.string().required('Şehir Seçilmelidir'),
    });

    const { handleSubmit, handleChange, handleBlur, values, errors, touched } = useFormik({
        initialValues: {
            description: '',
            positionId: '',
            wayOfWorkingId: '',
            workingTimeId: '',
            positionCount: '',
            cityId: '',
            minSalary: '',
            maxSalary: '',
            employerId: '',
        },
        validationSchema,
        onSubmit: values => {
            console.log(values);
            values.employerId = 4; // JWT olmadığı için iş ilanını veren kişinin id sini kendim giriyorum.
            postService.add(values).then(result => console.log(result.data))
        }
    })


    return (
        <>
            <Navbar transparent />

            <main>
                <div className="relative pt-16 pb-32 flex content-center items-center justify-center min-h-screen-75">
                    <div
                        className="absolute top-0 w-full h-full bg-center bg-cover"
                        style={{
                            backgroundImage:
                                "url('https://images.unsplash.com/photo-1557804506-669a67965ba0?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1267&q=80')",
                        }}
                    >
                        <span
                            id="blackOverlay"
                            className="w-full h-full absolute opacity-75 bg-black"
                        ></span>
                    </div>
                    <div className="container relative mx-auto">
                        <div className="items-center flex flex-wrap">
                            <div className="w-full lg:w-6/12 px-4 ml-auto mr-auto text-center">
                                <div className="pr-12">
                                    <h1 className="text-white font-semibold text-5xl">
                                    Yeni İlan Ekle
                                    </h1>
                                    <p className="mt-4 text-lg text-blueGray-200">
                                    
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div
                        className="top-auto bottom-0 left-0 right-0 w-full absolute pointer-events-none overflow-hidden h-70-px"
                        style={{ transform: "translateZ(0)" }}
                    >
                        <svg
                            className="absolute bottom-0 overflow-hidden"
                            xmlns="http://www.w3.org/2000/svg"
                            preserveAspectRatio="none"
                            version="1.1"
                            viewBox="0 0 2560 100"
                            x="0"
                            y="0"
                        >
                            <polygon
                                className="text-blueGray-200 fill-current"
                                points="2560 0 2560 100 0 100"
                            ></polygon>
                        </svg>
                    </div>
                </div>

               <section className="relative py-16 bg-blueGray-600 ">
                    <div className="container mx-auto px-4">
                        <div className="relative flex flex-col min-w-0 break-words bg-white w-full mb-6 shadow-xl rounded-lg -mt-64">
                        <div className="flex-auto px-4 lg:px-10 py-10 pt-0 bg-blueGray-100">

                            <form onSubmit={handleSubmit}>
                                <h6 className="text-blueGray-400 text-sm mt-3 mb-6 font-bold uppercase">
                                    İlan Bilgileriniz
                                </h6>

                                <div className="px-4 ">

                                    <div className="flex flex-wrap lg:w-12/12 ">
                                        <div className="w-full lg:w-12/12 px-4">
                                            <div className="relative w-full mb-3">
                                                <label
                                                    className="block uppercase text-blueGray-600 text-xs font-bold mb-2"
                                                    htmlFor="grid-password"
                                                >
                                                    İş Tanıtımı
                                                </label>
                                                <textarea
                                                    type="text"
                                                    name="description"
                                                    placeholder="İş Tanıtımı..."
                                                    onChange={handleChange}
                                                    onBlur={handleBlur}
                                                    values={values.description}
                                                    className="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150"
                                                />
                                                {errors.description &&
                                                    touched.description &&
                                                    <p className="text-sm text-red-500">{errors.description}</p>
                                                }
                                            </div>
                                        </div>
                                        <div className="w-full lg:w-6/12 px-4">
                                            <div className="relative w-full mb-3">
                                                <label
                                                    className="block uppercase text-blueGray-600 text-xs font-bold mb-2"
                                                    htmlFor="grid-password"
                                                >
                                                    Pozisyon
                                                </label>
                                                <select
                                                    className="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150"
                                                    value={values.positionId}
                                                    name="positionId"
                                                    onChange={handleChange}
                                                    onBlur={handleBlur}>
                                                    <option value="">Pozisyon Seçin</option>
                                                    {positions.map(position => {
                                                        return <option value={position.id}>{position.positionName}</option>
                                                    })}
                                                </select>
                                                {errors.positionId &&
                                                    touched.positionId &&
                                                    <p className="text-sm text-red-500">{errors.positionId}</p>
                                                }
                                            </div>
                                        </div>
                                        <div className="w-full lg:w-6/12 px-4">
                                            <div className="relative w-full mb-3">
                                                <label
                                                    className="block uppercase text-blueGray-600 text-xs font-bold mb-2"
                                                    htmlFor="grid-password"
                                                >
                                                    Şehir
                                                </label>
                                                <select
                                                    name="cityId"
                                                    onChange={handleChange}
                                                    onBlur={handleBlur}
                                                    values={values.cityId}
                                                    className="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150"
                                                >
                                                    <option value="">Şehir Seçin</option>
                                                    {cities.map(city => {
                                                        return <option value={city.id}>{city.name}</option>
                                                    })}
                                                </select>
                                                {errors.cityId &&
                                                    touched.cityId &&
                                                    <p className="text-sm text-red-500">{errors.cityId}</p>
                                                }
                                            </div>
                                        </div>
                                        <div className="w-full lg:w-6/12 px-4 mt-5">
                                            <div className="relative mb-3">
                                                <label
                                                    className="block uppercase text-blueGray-600 text-xs font-bold mb-2"
                                                    htmlFor="grid-password"
                                                >
                                                    Pozisyon Sayısı
                                                </label>
                                                <input
                                                    type="text"
                                                    name="positionCount"
                                                    onChange={handleChange}
                                                    onBlur={handleBlur}
                                                    values={values.positionCount}
                                                    placeholder="Pozisyon Sayısı"
                                                    className="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150"
                                                />
                                                {errors.positionCount &&
                                                    touched.positionCount &&
                                                    <p className="text-sm text-red-500">{errors.positionCount}</p>
                                                }
                                            </div>
                                        </div>
                                        <div className="w-full lg:w-6/12 px-4 mt-5">
                                            <div className="relative mb-3">
                                                <label
                                                    className="block uppercase text-blueGray-600 text-xs font-bold mb-2"
                                                    htmlFor="grid-password"
                                                >
                                                    Çalışma Şekli
                                                </label>
                                                <select
                                                    name="wayOfWorkingId"
                                                    onChange={handleChange}
                                                    onBlur={handleBlur}
                                                    values={values.wayOfWorkingId}
                                                    className="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150"
                                                >
                                                    <option value="">Çalışma Şeklini Seçin</option>
                                                    {Object.values(EnumWayOfWorking).map(working => {
                                                        return <option value={working.id}>{working}</option>
                                                    })}
                                                </select>
                                                {errors.wayOfWorkingId &&
                                                    touched.wayOfWorkingId &&
                                                    <p className="text-sm text-red-500">{errors.wayOfWorkingId}</p>
                                                }
                                            </div>
                                        </div>
                                        <div className="w-full lg:w-12/12 px-4 mt-5">
                                            <div className="relative mb-3">
                                                <label
                                                    className="block uppercase text-blueGray-600 text-xs font-bold mb-2"
                                                    htmlFor="grid-password"
                                                >
                                                    Çalışma Zamanı
                                                </label>
                                                <select
                                                    name="workingTimeId"
                                                    onChange={handleChange}
                                                    onBlur={handleBlur}
                                                    values={values.workingTimeId}
                                                    className="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150"
                                                >
                                                    <option value="">Çalışma Şeklini Seçin</option>
                                                    {Object.values(EnumPlaceOfWorking).map(time => {
                                                        return <option value={time.id}>{time}</option>
                                                    })}
                                                </select>
                                                {errors.workingTimeId &&
                                                    touched.workingTimeId &&
                                                    <p className="text-sm text-red-500">{errors.workingTimeId}</p>
                                                }
                                            </div>
                                        </div>
                                        <div className="w-full lg:w-6/12 px-4 mt-5">
                                            <div className="relative mb-3">
                                                <label
                                                    className="block uppercase text-blueGray-600 text-xs font-bold mb-2"
                                                    htmlFor="grid-password"
                                                >
                                                    Max Maaş
                                                </label>
                                                <input
                                                    type="text"
                                                    name="maxSalary"
                                                    onChange={handleChange}
                                                    onBlur={handleBlur}
                                                    values={values.maxSalary}
                                                    placeholder="Max Maaş"
                                                    className="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150"
                                                />
                                            </div>
                                        </div>
                                        <div className="w-full lg:w-6/12 px-4 mt-5">
                                            <div className="relative mb-3">
                                                <label
                                                    className="block uppercase text-blueGray-600 text-xs font-bold mb-2"
                                                    htmlFor="grid-password"
                                                >
                                                    Min Maaş
                                                </label>
                                                <input
                                                    type="text"
                                                    name="minSalary"
                                                    onChange={handleChange}
                                                    onBlur={handleBlur}
                                                    values={values.minSalary}
                                                    placeholder="Min Maaş"
                                                    className="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150"
                                                />
                                            </div>
                                        </div>
                                    </div>

                                    <div className="flex flex-wrap">


                                    </div>
                                    <hr className="mt-6 border-b-1 border-blueGray-300" />
                                    <div className="flex flex-wrap justify-end">
                                        <button type="submit" className="bg-emerald-500 mt-4 text-white active:bg-emerald-600 font-bold uppercase text-xs px-6 py-3 rounded shadow hover:shadow-md outline-none focus:outline-none mr-1 ease-linear transition-all duration-150">
                                            Kaydet
                                        </button>

                                    </div>

                                </div>


                            </form>

</div>
                        </div>
                    </div>
                </section>
            </main>
            <Footer />
        </>

    )
}