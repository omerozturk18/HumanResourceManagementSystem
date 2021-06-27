import { useField } from 'formik'
import React from 'react'

export default function HrmsTextInput({ ...props }) {
    const [field, meta] = useField(props)
    return (
        <div>
            <label className="block text-blueGray-600 text-sm font-bold mb-2">{props.placeholder}</label>
            <input
                {...field} {...props}
                className="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150"
            />
            {meta.touched && !!meta.error ? (
                <span className="text-sm text-red-500">{meta.error}</span>
            ) : null}
        </div>
    )
}
