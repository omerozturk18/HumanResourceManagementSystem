import React from "react";
import ReactDOM from "react-dom";
import { BrowserRouter, Route, Switch, Redirect } from "react-router-dom";
import { Provider } from 'react-redux';
import { configureStore } from './store/configureStore';

import "@fortawesome/fontawesome-free/css/all.min.css";
import "assets/styles/tailwind.css";
import 'reactjs-popup/dist/index.css';

// layouts

import Admin from "layouts/Admin";
import Auth from "layouts/Auth";

// views without layouts

import Profile from "views/Profile";
import Index from "views/Index";
import JobPostingList from "views/JobPostingList";
import EmployeeDetail from "views/Employee/EmployeeDetail";
import EmployeeEdit from "views/Employee/EmployeeEdit";
import Employee from "views/Employee/Employee";
import JobPostingEdit from "views/JobPostingEdit";
import JobPostingDetail from "views/JobPostingDetail";
import Employer from "views/Employer";
import SystemUser from "views/SystemUser";


const store = configureStore()
ReactDOM.render(
  <Provider store={store}>
  <BrowserRouter>
    <Switch>
      {/* add routes with layouts */}
      <Route path="/admin" component={Admin} />
      <Route path="/auth" component={Auth} />
      {/* add routes without layouts */}
      <Route path="/profile" exact component={Profile} />
      <Route path="/" exact component={Index} />
      <Route path="/jobPostingList" component={JobPostingList}/>
      <Route path="/jobPostingEdit" component={JobPostingEdit}/>
      <Route path="/jobPostingDetail" component={JobPostingDetail}/>


      <Route path="/employeeDetail/:empoleeId" component={EmployeeDetail}/>
      <Route path="/employeeEdit/:empoleeId" component={EmployeeEdit}/>
      
      <Route path="/employer" component={Employer}/>
      <Route path="/employee" component={Employee}/>
      <Route path="/systemuser/edit" component={SystemUser}/>

      {/* add redirect for first page */}
      <Redirect from="*" to="/" />
    </Switch>
  </BrowserRouter>
     </Provider >, document.getElementById('root')

);
