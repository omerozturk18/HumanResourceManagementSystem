import City from 'components/City';
import PlaceOfWorking from 'components/EnumComponents/PlaceOfWorking';
import WayOfWorking from 'components/EnumComponents/WayOfWorking';
import { EnumPlaceOfWorking } from 'enums/EnumPlaceOfWorking';
import { EnumWayOfWorking } from 'enums/EnumWayOfWorking';


import React, { useState, useEffect } from 'react'
import JobPostgingService from '../services/employerServices/jobPostingService';
import JobPosition from './JobPosition';

export default function JobPostingList({ color }) {
  const [jobPostgings, setActiveJobPostgings] = useState([]);

  useEffect(() => {
    let jobPostingService = new JobPostgingService()
    jobPostingService.getActiveJobPostgings().then(result => setActiveJobPostgings(result.data.data))
  }, [])
  return (

    <>
      <div className="flex flex-wrap">
        <div className="w-1/3 px-4 md:w-4/12 ">
          <span className="text-sm block my-4 p-3 text-blueGray-700 rounded border border-solid border-blueGray-100">
            <nav>
              <ul>
                <li>
                  <City />
                </li>
                <li>
                  <JobPosition/>
                </li>
                <li>
                 <WayOfWorking/>
                </li>
                <li>
                  <PlaceOfWorking/>
                </li>

              </ul>
            </nav>
          </span>
        </div>
        <div className="w-full md:w-8/12 mt-6">
          {
            jobPostgings.map(jobPostging => (
              <div className="md:flex mb-8" key={jobPostging.id}>
                <div className="  pt-8 border-r border-b border-l border-grey-light lg:border-l-0 lg:border-t lg:border-grey-light  bg-blueGray-600 shadow-lg rounded-xl p-4 flex flex-col justify-between leading-normal">
                  <div className="container px-4 mx-auto">
                    <div className="flex flex-wrap">
                      <div className="flex items-start">
                        <img className="w-20 h-16 rounded-full mr-4" src={require("assets/img/react.png").default} alt="Avatar of Jonathan Reinink" />
                      </div>
                      <div className="w-full px-4 md:w-4/12">
                        <div className="w-full px-4 md:w-12/12">
                          <p className="text-white leading-none font-bold text-xl mb-2">{jobPostging.jobPosition.positionName}</p>
                        </div>
                        <div className="w-full px-4 md:w-1/12">
                          <p className="text-white leading-none ">{jobPostging.employer.companyName}</p>
                        </div>
                      </div>
                      <div className="ml-auto">
                        <div className="text-blueGray-500 mr-2 p-2 text-center inline-flex items-center justify-center shadow-lg rounded-full bg-white">
                          <span className="fas fa-map-marked text-md "> {jobPostging.city.name}</span>
                        </div>
                        <div className="text-blueGray-500 p-2 mr-2 text-center inline-flex items-center  justify-center  shadow-lg rounded-full bg-white">
                          <span className="fas fa-user-friends text-md "> {jobPostging.openPositionCount}</span>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div className="flex items-center px-4 mt-2">
                    <div className="text-sm">
                      <p className="text-white text-base">{jobPostging.jobDescription}</p>
                    </div>
                  </div>
                  <div className="flex items-center mt-4 px-4">
                    <div className="text-teal-600 bg-teal-200 p-2 mr-2 text-center inline-flex items-center justify-center   shadow-lg rounded-full bg-white">
                      <span className="fas fa-hourglass-end  text-md ">
                      {  EnumWayOfWorking[jobPostging.wayOfWorking] }
                      </span>
                    </div>
                    <div className="text-amber-600 bg-amber-200 p-2 text-center inline-flex items-center justify-center   shadow-lg rounded-full bg-white mr-4">
                      <span className="fas fa-place-of-worship mr-2 text-md "> 
                      { EnumPlaceOfWorking[jobPostging.placeOfWorking] }
                      </span>
                    </div>
                    <button
                      className="ml-auto bg-lightBlue-600 text-white active:bg-red-100 text-xs font-bold uppercase px-4 py-2 rounded shadow hover:shadow-lg outline-none focus:outline-none lg:mr-1 lg:mb-2 ml-3 mb-3 ease-linear transition-all duration-150"
                      type="button"
                    >
                      <i className="fas fa-file-alt"></i> Detay
                    </button>
                  </div>
                  <p className="text-white text-base"><b className="text-blueGray-300 text-base">Yayınlanma Tarihi: </b><b>{jobPostging.releaseDate}</b></p>
                </div>
              </div>
            ))}
        </div>
      </div>
    </>
  );
}

