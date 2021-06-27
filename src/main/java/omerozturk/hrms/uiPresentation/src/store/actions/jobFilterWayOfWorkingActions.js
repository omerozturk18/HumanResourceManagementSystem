export const FILTER_TO_WAY_OF_WORKING = "FILTER_TO_WAY_OF_WORKING"

export function wayOfWorkingFilter(wayOfWorking) {
    return {
        type: FILTER_TO_WAY_OF_WORKING,
        payload: wayOfWorking
    }
}