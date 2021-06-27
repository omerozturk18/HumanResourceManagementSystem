import { FILTER_TO_WAY_OF_WORKING } from "../actions/jobFilterWayOfWorkingActions";
import { jobFilterWayOfWorkingItems } from "../initialValues/jobFilterWayOfWorkingItems";

const initialState = {
    jobFilterWayOfWorkingItems: jobFilterWayOfWorkingItems
}

export default function jobFilterWayOfWorkingReducer(state = initialState, { type, payload }) {
    switch (type) {
        case FILTER_TO_WAY_OF_WORKING:
            let wayOfWorking = state.jobFilterWayOfWorkingItems.find(c =>  c.wayOfWorking.id === payload.id)
            if (wayOfWorking) {
                state.jobFilterWayOfWorkingItems = state.jobFilterWayOfWorkingItems.filter(c => c.wayOfWorking.id !== payload.id)
                return {
                    ...state
                }
            } else {
                return {
                    ...state,
                    jobFilterWayOfWorkingItems: [...state.jobFilterWayOfWorkingItems, { quantity: 4, wayOfWorking: payload }]
                }
            }

        default:
            return state;
    }
}
