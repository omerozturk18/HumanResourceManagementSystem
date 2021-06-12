import React from "react";

// components

import CardTable from "components/Cards/CardTable.js";
import JobPostingList from "views/JobPostingList";
import EmployeeDetail from "views/Employee/EmployeeDetail";
import EmployerDetail from "views/EmployerDetail";

export default function Tables() {
  return (
    <>
      <div className="flex flex-wrap mt-4">
        <div className="w-full mb-12 px-4">
        <JobPostingList/>
        </div>
        <div className="w-full mb-12 px-4">

          <EmployeeDetail color="dark" />
        </div>
        <div className="w-full mb-12 px-4">

          <EmployerDetail color="danger" />
        </div>
        <div className="w-full mb-12 px-4">

          <CardTable color="warning" />
        </div>
      </div>
    </>
  );
}
