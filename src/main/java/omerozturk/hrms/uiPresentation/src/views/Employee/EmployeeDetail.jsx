import React, { useState, useEffect } from 'react'
import EmployeeService from 'services/employeeServices/employeeService';

export default function EmployeeDetail() {
  const [employee, setEmployee] = useState([]);

  useEffect(() => {
    let employeeService = new EmployeeService();
    employeeService.getByEmployeeId(1).then(result => setEmployee(result.data.data));
  }, []);

  return (
    <>
      <div className="flex flex-wrap justify-center">
        <div className="mb-12">
          <div className="w-full lg:w-3/12 px-4 lg:order-2 flex justify-center">
            <div className="relative">
              <img
                alt="..."
                src={(employee.employeeImages) != null ? employee.employeeImages[1].url : ""}
                className="shadow-xl rounded-full h-auto align-middle border-none absolute -m-16 -ml-20 lg:-ml-16 max-w-150-px"
              />
            </div>
          </div>
        </div>
        <div className="w-full lg:w-12/12 mt-8 px-4 lg:order-1">
          <div className="flex justify-left py-4 lg:pt-4 pt-8">
            <div className="mr-4 p-3 text-center">
              <span className="text-xl font-bold block uppercase tracking-wide text-blueGray-600">22</span>
              <span className="text-sm text-blueGray-400">Başvuru</span>
            </div>
            <div className="mr-4 p-3 text-center">
              <span className="text-xl font-bold block uppercase tracking-wide text-blueGray-600"> 10</span>
              <span className="text-sm text-blueGray-400"> Görüntüleme </span>
            </div>
            <div className="lg:mr-4 p-3 text-center">
              <span className="text-xl font-bold block uppercase tracking-wide text-blueGray-600"> 89</span>
              <span className="text-sm text-blueGray-400">Mesaj </span>
            </div>
          </div>
        </div>
      </div>
      <div className="text-center ">
        <h3 className="text-4xl font-semibold leading-normal mb-2 text-blueGray-700 mb-2 uppercase">
          {employee.firstName} {employee.lastName}
        </h3>
        <div className="text-sm leading-normal mt-0 mb-2 text-blueGray-400 font-bold uppercase">
          <i className="fas fa-map-marker-alt mr-2 text-lg text-blueGray-400"></i>{" "}
                    Ankara, Türkiye
                  </div>
        <div className="mb-2 text-blueGray-600 mt-10">
          {
            employee.resumes != null ? employee.resumes.map(resume => (
              resume.workExperiences.map(workExperience => (
                <div className="mb-1" key={workExperience.id}>
                  <i className="fas fa-briefcase mr-2 text-lg text-blueGray-400"></i>
                  {workExperience.jobPosition}-{workExperience.workPlaceName}     {workExperience.dateOfStart}
                </div>
              ))
            )) : ""
          }
        </div>
        <div className="mb-2 text-blueGray-600 mt-5">
          {
            employee.resumes != null ? employee.resumes.map(resume => (
              resume.schools.map(school => (
                <div className="mb-1" key={school.id}>
                  <i className="fas fa-university mr-2 text-lg text-blueGray-400"></i>
                  {school.schoolName}-{school.sectionName}     {school.startingDate}
                </div>
              ))
            )) : ""
          }
        </div>
      </div>
      <div className="mt-10 py-10 border-t border-blueGray-200 text-center">
        <div className="flex flex-wrap justify-center">
          <div className="w-full lg:w-9/12 px-4">
            <p className="mb-4 text-lg leading-relaxed text-blueGray-700">
              {employee.resumes != null ? employee.resumes[0].description : ""}
            </p>
            <a
              href="#pablo"
              className="font-normal text-lightBlue-500"
              onClick={(e) => e.preventDefault()}
            >
              Show more
                      </a>
          </div>
        </div>
        <button className=" bg-green text-white active:bg-pink-600 font-bold uppercase text-xs px-6 py-3 rounded shadow hover:shadow-lg outline-none focus:outline-none mr-1 mb-1 ease-linear transition-all duration-150"
                                                type="button" ><i className="fas fa-save"></i>  Düzenle</button>
      </div>

    </>
  );
}
