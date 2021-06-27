
import {FILTER_TO_POSITION } from "../actions/jobFilterPositionActions";
import { jobFilterPositionItems } from "../initialValues/jobFilterPositionItems";

const initialState = {
    jobFilterPositionItems: jobFilterPositionItems
}

export default function jobFilterPositonReducer(state = initialState, { type, payload }) {
    switch (type) {
        case FILTER_TO_POSITION:
            let position = state.jobFilterPositionItems.find(c => c.position.id === payload.id)
            if (position) {
                state.jobFilterPositionItems = state.jobFilterPositionItems.filter(c => c.position.id !== payload.id)
                //position.quantity++;
                return {
                    ...state
                }
            } else {
                return {
                    ...state,
                    jobFilterPositionItems: [...state.jobFilterPositionItems, { quantity: 2, position: payload }]
                }
            }
        default:
            return state;
    }
}