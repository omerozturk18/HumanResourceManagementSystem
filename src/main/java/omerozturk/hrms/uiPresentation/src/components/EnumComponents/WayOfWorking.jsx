import { EnumWayOfWorking } from 'enums/EnumWayOfWorking'
import React from 'react'
import { useDispatch } from 'react-redux';
import { wayOfWorkingFilter } from 'store/actions/jobFilterWayOfWorkingActions';

export default function WayOfWorking() {
    const dispatch = useDispatch()
    const filterWayOfWorking = (wayOfWorking) => {
        dispatch(wayOfWorkingFilter(wayOfWorking));
      };
    return (
        <div className=" w-full px-4 text-start">
                <div className="relative flex flex-col min-w-0 break-words bg-white w-full mb-8 shadow-lg rounded-lg">
                    <div className="px-4 py-5 flex-auto">
                        <div className="text-white p-2 text-center inline-flex items-center justify-center  mb-5 shadow-lg rounded-full bg-emerald-400">
                            <i className="fas fa-fingerprint mr-2"></i>
                            <span><h6 className="text-xl text-white font-semibold">Çalışma Şekli</h6></span>
                        </div>
                        <form className="md:flex hidden flex-row flex-wrap items-center lg:ml-auto mr-3">
                            <div className="relative flex w-full flex-wrap items-stretch">
                                <span className="z-10 h-full leading-snug font-normal absolute text-center text-blueGray-300 absolute bg-transparent rounded text-base items-center justify-center w-8 pl-3 py-3">
                                    <i className="fas fa-search"></i>
                                </span>
                                <input
                                    type="text"
                                    placeholder="Çalışma Şekli Ara"
                                    className="px-3 py-3 placeholder-blueGray-300 text-blueGray-600 relative mb-4 border-blueGray-300 rounded text-sm outline-none focus:outline-none w-full pl-10"
                                />
                            </div>
                        </form>
                        <div className="max-h-250-px overflow-y-auto mx-4" >
                            {Object.keys(EnumWayOfWorking).map(wayOfWorking => (
                                <div key={wayOfWorking}>
                                    <label className="inline-flex items-center cursor-pointer" onClick={() => filterWayOfWorking(wayOfWorking)}>
                                        <input
                                            id="customCheckLogin"
                                            type="checkbox"
                                            className="form-checkbox rounded text-blueGray-700 ml-1 mr-3 border-blueGray-400 w-4 h-4 ease-linear transition-all duration-150"
                                        />
                                        <p className="text-blueGray-500 text-sm leading-relaxed">
                                            {EnumWayOfWorking[wayOfWorking]}
                                        </p>
                                    </label>
                                </div>
                            ))}
                        </div>
                    </div>
                </div>
            </div>
    )
}
