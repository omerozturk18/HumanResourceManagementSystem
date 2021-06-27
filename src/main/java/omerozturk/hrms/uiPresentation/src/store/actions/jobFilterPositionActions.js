
export const FILTER_TO_POSITION = "FILTER_TO_POSITION"


export function positionFilter(position) {
    return {
        type: FILTER_TO_POSITION,
        payload: position
    }
}
