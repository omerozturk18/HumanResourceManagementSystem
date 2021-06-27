import { FILTER_TO_CITY } from "../actions/jobFilterCityActions";
import { jobFilterCityItems } from "../initialValues/jobFilterCityItems";

const initialState = {
    jobFilterCityItems: jobFilterCityItems
}

export default function jobFilterCityReducer(state = initialState, { type, payload }) {
    switch (type) {
        case FILTER_TO_CITY:
            let city = state.jobFilterCityItems.find(c =>  c.city.id === payload.id)
            if (city) {
                state.jobFilterCityItems = state.jobFilterCityItems.filter(c => c.city.id !== payload.id)
                return {
                    ...state
                }
            } else {
                return {
                    ...state,
                    jobFilterCityItems: [...state.jobFilterCityItems, { quantity: 1, city: payload }]
                }
            }

        default:
            return state;
    }
}
