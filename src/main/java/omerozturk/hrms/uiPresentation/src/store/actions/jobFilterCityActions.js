export const FILTER_TO_CITY = "FILTER_TO_CITY"

export function cityFilter(city) {
    return {
        type: FILTER_TO_CITY,
        payload: city
    }
}