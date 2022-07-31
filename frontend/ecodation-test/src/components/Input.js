import React from "react";

function Input({ name, label, errors, register, type = "text" }) {
  return (
    <div className="from-group mt-3">
      <label htmlFor={name}>{label}</label>
      <input
        type={type}
        className={errors[name] ? "form-control is-invalid" : "form-control"}
        {...register(name, { required: true })}
      />
      {errors[name]?.type === "required" && `${label} is required`}
    </div>
  );
}

export default Input;
