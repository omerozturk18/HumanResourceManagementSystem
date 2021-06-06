import React from "react";
import { Grid } from 'semantic-ui-react'
import JobPostgingList from "../pages/JobPostgingList";

export default function Dashboard() {
  return (
    <div>
      <Grid>
        <Grid.Column width={4}>
        </Grid.Column>
        <Grid.Column width={12}>
          <JobPostgingList/>
        </Grid.Column>
      </Grid>
    </div>
  );
}