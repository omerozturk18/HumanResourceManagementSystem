//tüm statetler burada toplanır

import { combineReducers } from "redux";
import jobFilterCityReducer from "./reducers/jobFilterCityReducer";
import jobFilterPositionReducer from "./reducers/jobFilterPositionReducer";
import jobFilterWayOfWorkingReducer from "./reducers/jobFilterWayOfWorkingReducer";
import jobFilterPlaceOfWorkingReducer from "./reducers/jobFilterPlaceOfWorkingReducer";
const rootReducer=combineReducers({
    jobFilterCity:jobFilterCityReducer,
    jobFilterPosition:jobFilterPositionReducer,
    jobFilterWayOfWorking:jobFilterWayOfWorkingReducer,
    jobFilterPlaceOfWorking:jobFilterPlaceOfWorkingReducer
})

export default rootReducer;