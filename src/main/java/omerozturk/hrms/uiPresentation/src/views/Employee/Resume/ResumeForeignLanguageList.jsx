import React, { useState, useEffect } from 'react'
import ResumeService from 'services/employeeServices/resumeService';

export default function ResumeForeignLanguageList({ color }) {
    const [resume, setByEmployeeId] = useState([]);

    useEffect(() => {
        let resumeService = new ResumeService()
        resumeService.getByEmployeeId(1).then(result => setByEmployeeId(result.data.data))
    }, [])
    return (
        <div
            className={
                "relative flex flex-col min-w-0 break-words w-full mb-6 shadow-lg rounded " +
                (color === "light" ? "bg-white" : "bg-lightBlue-900 text-white")
            }
        >
            <div className="rounded-t mb-0 px-4 py-3 border-0">
                <div className="flex flex-wrap items-center">
                    <div className="relative w-full px-4 max-w-full flex-grow flex-1">
                        <h3
                            className={
                                "font-semibold text-lg " +
                                (color === "light" ? "text-blueGray-700" : "text-white")
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
                                    (color === "light"
                                        ? "bg-blueGray-50 text-blueGray-500 border-blueGray-100"
                                        : "bg-lightBlue-800 text-lightBlue-300 border-lightBlue-700")
                                }
                            >
                                Yabancı Dil

                </th>
                            <th
                                className={
                                    "px-6 align-middle border border-solid py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-left " +
                                    (color === "light"
                                        ? "bg-blueGray-50 text-blueGray-500 border-blueGray-100"
                                        : "bg-lightBlue-800 text-lightBlue-300 border-lightBlue-700")
                                }
                            >
                                Yabancı Dil Seviyesi
                </th>

                        </tr>
                    </thead>
                    <tbody>
                        {
                            resume.foreignLanguages != null ? resume.foreignLanguages.map(foreignLanguage => (
                                <tr>
                                    <th className="border-t-0 px-6 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4 text-left flex items-center">
                                        <span
                                            className={
                                                "ml-3 font-bold " +
                                                +(color === "light" ? "text-blueGray-600" : "text-white")
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
                                                        style={{ width: foreignLanguage.languageLevel+"%" }}
                                                        className={"shadow-none flex flex-col text-center whitespace-nowrap text-white justify-center "+(foreignLanguage.languageLevel>70?"bg-emerald-500":"bg-red-500")}
                                                    ></div>
                                                </div>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                            )) : ""}
                    </tbody>
                </table>
            </div>
        </div>
    )
}
