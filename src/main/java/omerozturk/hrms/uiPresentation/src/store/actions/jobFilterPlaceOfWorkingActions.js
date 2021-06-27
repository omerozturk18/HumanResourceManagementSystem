
export const FILTER_TO_PLACE_OF_WORKING = "FILTER_TO_PLACE_OF_WORKING"

export function placeOfWorkingFilter(placeOfWorking) {
    return {
        type: FILTER_TO_PLACE_OF_WORKING,
        payload: placeOfWorking
    }
}