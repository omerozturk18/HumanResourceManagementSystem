import React from "react";
import ReactDOM from "react-dom";
import { BrowserRouter, Route, Switch, Redirect } from "react-router-dom";

import "@fortawesome/fontawesome-free/css/all.min.css";
import "assets/styles/tailwind.css";

// layouts

import Admin from "layouts/Admin";
import Auth from "layouts/Auth";

// views without layouts

import Landing from "views/Landing";
import Profile from "views/Profile";
import Index from "views/Index";
import JobPostingList from "views/JobPostingList";
import EmployeeDetail from "views/Employee/EmployeeDetail";
import EmployeeEdit from "views/Employee/EmployeeEdit";
import Employee from "views/Employee/Employee";
import JobPostingDetail from "views/JobPostingDetail";

ReactDOM.render(
  <BrowserRouter>
    <Switch>
      {/* add routes with layouts */}
      <Route path="/admin" component={Admin} />
      <Route path="/auth" component={Auth} />
      {/* add routes without layouts */}
      <Route path="/landing" exact component={Landing} />
      <Route path="/profile" exact component={Profile} />
      <Route path="/" exact component={Index} />
      <Route path="/jobPostingList" component={JobPostingList}/>
      <Route path="/jobPostingDetail" component={JobPostingDetail}/>

      <Route path="/employeeDetail/:empoleeId" component={EmployeeDetail}/>
      <Route path="/employeeEdit/:empoleeId" component={EmployeeEdit}/>
      <Route path="/employee" component={Employee}/>


      {/* add redirect for first page */}
      <Redirect from="*" to="/" />
    </Switch>
  </BrowserRouter>,
  document.getElementById("root")
);
