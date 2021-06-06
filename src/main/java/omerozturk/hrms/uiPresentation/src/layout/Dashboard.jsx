import React from "react";
import { Grid } from 'semantic-ui-react'
import JobPostgingList from "../pages/JobPostgingList";
import Employee from "./EmployeeComponent/Employee";
import Resume from "./EmployeeComponent/Resume";

export default function Dashboard() {
  return (
    <div>
      <Grid>

        <Grid.Column width={16}>
          <JobPostgingList/>
        </Grid.Column>
    

        <Grid.Column width={16}>
          <Resume/>
        </Grid.Column>
        <Grid.Column width={16}>
          <Employee/>
        </Grid.Column>
      </Grid>
    </div>
  );
}