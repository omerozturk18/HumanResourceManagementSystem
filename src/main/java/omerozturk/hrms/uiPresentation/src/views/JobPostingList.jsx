import City from 'components/City';
import PlaceOfWorking from 'components/EnumComponents/PlaceOfWorking';
import WayOfWorking from 'components/EnumComponents/WayOfWorking';
import { EnumPlaceOfWorking } from 'enums/EnumPlaceOfWorking';
import { EnumWayOfWorking } from 'enums/EnumWayOfWorking';
import React, { useState, useEffect } from 'react'
import JobPostgingService from '../services/employerServices/jobPostingService';
import JobPosition from './JobPosition';
import { useSelector } from 'react-redux'
import Pagination from "react-js-pagination";
import FavoriteJobPostingService from 'services/employeeServices/favoriteJobPostingService';


export default function JobPostingList({ color }) {
  const [jobPostgings, setActiveJobPostgings] = useState([]);
  const { jobFilterCityItems } = useSelector(state => state.jobFilterCity)
  const { jobFilterPositionItems } = useSelector(state => state.jobFilterPosition)
  const { jobFilterWayOfWorkingItems } = useSelector(state => state.jobFilterWayOfWorking)
  const { jobFilterPlaceOfWorkingItems } = useSelector(state => state.jobFilterPlaceOfWorking)
  const [activePage, setActivePage] = useState(1);

  useEffect(() => {
    let jobPostingService = new JobPostgingService()
    jobPostingService.getActiveJobPostgings().then(result => setActiveJobPostgings(result.data.data))
  }, [])
  const addFavorite = (employeeId,jobPosting) => {
      let favoriteJobPostingService = new FavoriteJobPostingService()
      favoriteJobPostingService.add({employeeId:employeeId,jobPosting:jobPosting});
  };
  const handlePageChange = (pageNumber) => {
    console.log(`active page is ${pageNumber}`);
    setActivePage(pageNumber);
  };
  let jobPostgingFilter = jobPostgings.map(obj => ({ ...obj }));

  if (jobFilterPositionItems.length > 0) {
    jobFilterPositionItems.forEach(j => {
      jobPostgingFilter = jobPostgingFilter.filter(x => x.jobPosition.id === j.position.id)
    })
  }
  if (jobFilterCityItems.length > 0) {
    jobFilterCityItems.forEach(j => {
      jobPostgingFilter = jobPostgingFilter.filter(x => x.city.id === j.city.id)
    })
  }
  if (jobFilterWayOfWorkingItems.length > 0) {
    jobFilterWayOfWorkingItems.forEach(j => {
      jobPostgingFilter = jobPostgingFilter.filter(x => x.wayOfWorking === j.wayOfWorking)
    })
  }
  if (jobFilterPlaceOfWorkingItems.length > 0) {
    jobFilterPlaceOfWorkingItems.forEach(j => {
      jobPostgingFilter = jobPostgingFilter.filter(x => x.placeOfWorking === j.placeOfWorking)
    })
  }
  const list = jobPostgingFilter.length ? (
    jobPostgingFilter.map(jobPostging => (
      <div className="md:flex mb-8" key={jobPostging.id}>
        <div className="  pt-8 border-r border-b border-l border-white lg:border-l-0 lg:border-t 
        shadow-lg rounded-xl p-4 flex flex-col justify-between leading-normal bg-white">
          <div className="container px-4 mx-auto">
            <div className="flex flex-wrap">
              <div className="flex items-start">
                <img className="w-20 h-16 rounded-full mr-4" src={require("assets/img/react.png").default} alt="Avatar of Jonathan Reinink" />
              </div>
              <div className="w-full px-4 md:w-4/12">
                <div className="w-full px-4 md:w-12/12">
                  <p className="text-blueGray-600 leading-none font-bold text-xl mb-2">{jobPostging.jobPosition.positionName}</p>
                </div>
                <div className="w-full px-4 md:w-1/12">
                  <p className="text-blueGray-600 leading-none ">{jobPostging.employer.companyName}</p>
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
              <p className="text-blueGray-600 text-base">{jobPostging.jobDescription}</p>
            </div>
          </div>
          <div className="flex items-center mt-4 px-4">
            <div className="text-teal-600 bg-teal-200 p-2 mr-2 text-center inline-flex items-center justify-center   shadow-lg rounded-full bg-white">
              <span className="fas fa-hourglass-end  text-md ">
                {EnumWayOfWorking[jobPostging.wayOfWorking]}
              </span>
            </div>
            <div className="text-amber-600 bg-amber-200 p-2 text-center inline-flex items-center justify-center   shadow-lg rounded-full bg-white mr-4">
              <span className="fas fa-place-of-worship mr-2 text-md">
                {EnumPlaceOfWorking[jobPostging.placeOfWorking]}
              </span>
            </div>
            <button
              className="ml-auto bg-pink-500 text-white active:bg-red-100 text-sm font-bold  px-4 py-2 rounded shadow hover:shadow-lg outline-none focus:outline-none lg:mr-1 lg:mb-2 ml-3 mb-3 ease-linear transition-all duration-150"
              type="button" onClick={()=>addFavorite(1,jobPostging)}
            >
              <i className="fas fa-heart"></i> Favorilere Ekle
            </button>
            <button
              className=" bg-lightBlue-600 text-white active:bg-red-100 text-sm font-bold  px-4 py-2 rounded shadow hover:shadow-lg outline-none focus:outline-none lg:mr-1 lg:mb-2 ml-3 mb-3 ease-linear transition-all duration-150"
              type="button"
            >
              <i className="fas fa-file-alt"></i> Detay
            </button>
          </div>
          <p className="text-blueGray-400 text-base">Yayınlanma Tarihi: {jobPostging.releaseDate}</p>
        </div>
      </div>
    ))

  ) : (
    <div className="flex flex-wrap">
      <div className="  pt-8 border-r border-b border-l border-white lg:border-l-0 lg:border-t 
        shadow-lg rounded-xl p-4 flex flex-col justify-between leading-normal bg-white">
        <p className="text-blueGray-400 text-base">Bulunamadı</p>
      </div>
    </div>
  )
  return (

    <>
      <div className="w-full">
        <div className="flex flex-wrap">
          <div className="w-4/12 px-12">
            <span className="text-sm block my-4 p-3 text-blueGray-700 rounded border border-solid border-blueGray-100">
              <nav>
                <ul>
                  <li>
                    <City />
                  </li>
                  <li>
                    <JobPosition />
                  </li>
                  <li>
                    <WayOfWorking />
                  </li>
                  <li>
                    <PlaceOfWorking />
                  </li>
                  <li>
                  </li>
                </ul>
              </nav>
            </span>
          </div>
          <div className="md:w-8/12 pt-6">
            {list}
            <div className="py-2 mt-2 px-2">

              <nav className="block flex justify-end	">
                <Pagination
                  firstPageText="🡸"
                  lastPageText="🡺"
                  prevPageText="🡠"
                  nextPageText="🡪"
                  activePage={activePage}
                  totalItemsCount={1}
                  pageRangeDisplayed={jobPostgingFilter.length}
                  linkClass="first:ml-0 text-xs font-semibold flex w-8 h-8 mx-1 p-0 rounded-full items-center justify-center leading-tight relative border border-solid border-lightBlue-500 bg-white text-lightBlue-500"
                  innerClass="flex pl-0 rounded list-none flex-wrap"
                  activeClass="first:ml-0 text-xs font-semibold flex w-8 h-8 mx-1 p-0 rounded-full items-center justify-center leading-tight relative border border-solid border-lightBlue-500 bg-white text-lightBlue-500"
                  itemClass=""
                  onChange={handlePageChange.bind(this)}
                ></Pagination>
              </nav>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}
