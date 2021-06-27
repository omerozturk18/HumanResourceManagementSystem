import { FILTER_TO_PLACE_OF_WORKING } from "../actions/jobFilterPlaceOfWorkingActions";
import { jobFilterPlaceOfWorkingItems } from "../initialValues/jobFilterPlaceOfWorkingItems";

const initialState = {
    jobFilterPlaceOfWorkingItems: jobFilterPlaceOfWorkingItems
}

export default function jobFilterPlaceOfWorkingReducer(state = initialState, { type, payload }) {
    switch (type) {
        case FILTER_TO_PLACE_OF_WORKING:
            let placeOfWorking = state.jobFilterPlaceOfWorkingItems.find(c =>  c.placeOfWorking.id === payload.id)
            if (placeOfWorking) {
                state.jobFilterPlaceOfWorkingItems = state.jobFilterPlaceOfWorkingItems.filter(c => c.placeOfWorking.id !== payload.id)
                return {
                    ...state
                }
            } else {
                return {
                    ...state,
                    jobFilterPlaceOfWorkingItems: [...state.jobFilterPlaceOfWorkingItems, { quantity: 3, placeOfWorking: payload }]
                }
            }

        default:
            return state;
    }
}
