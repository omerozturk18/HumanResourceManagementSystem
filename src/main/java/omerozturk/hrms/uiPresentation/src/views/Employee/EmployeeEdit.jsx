import React from 'react'
import EmployeeDetail from './EmployeeDetail'
import EmployeeSettings from './EmployeeSettings'

export default function EmployeeEdit() {
    return (
        <>
        <div className="flex flex-wrap">
          <div className="w-full lg:w-8/12 px-4">
            <EmployeeSettings/>
          </div>
          <div className="w-full lg:w-4/12 px-4">
            <EmployeeDetail />
          </div>
        </div>
      </>
    )
}
