import React from 'react'

export default function HrmsLabel({ ...props }) {
    return (
        <div>
            <label className="block text-blueGray-600 text-sm font-bold mb-2">{props.value} </label>
        </div>
    )
}
