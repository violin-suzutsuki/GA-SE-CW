import { data } from "autoprefixer";
import React from "react";
import { useState } from "react";
import reportInfo from '../reportInfo.json';

function InputsBar({ setTableData, setTableTpl, setLoading }) {
  const [inputs, setInputs] = useState({id: "1", userInput1: "User Input One", userInput2: "User Input Two"}) 
  const [labels, setLabels] = useState({labelOne: "Input One", labelTwo: "Input Two"})
  
  // setTableData is from the App
  const getData = (id, userInput1, userInput2) => {
    setTableTpl(id)
    setLoading(true)
    const responseFromAPI = fetch(`/api/report?reportId=${id}&userInput=${userInput1}&userInput2=${userInput2}`)
      .then((response) => response.json())
      .then((responseJSON) => {
        // do stuff with responseJSON here...
        console.log(responseJSON);
        setTableData(responseJSON);
      });
    setLoading(false);
  };

  const hideShowInput = (id) => {
    var input1 = document.getElementById("input1");
    var input2 = document.getElementById("input2")

    reportInfo.map(data => {
      if(data.id == id) {
        var firstInput = data.labelOneText !== "";
        input1.disabled = !firstInput;
        input1.parentElement.style.display = firstInput ? "block" : "none";

        var secondInput = data.labelTwoText !== "";
        input2.disabled = !secondInput;
        input2.parentElement.style.display = secondInput ? "block" : "none";

        setLabels({labelOne: data.labelOneText, labelTwo: data.labelTwoText})
      }
    })
  };

  const handleSubmit = Event => {
    Event.preventDefault();
    getData(inputs.id, inputs.userInput1, inputs.userInput2)
    document.getElementById("input1").value="";
    document.getElementById("input2").value=""
  }

  return (
    <div className="container mx-auto py-12">
      <form className="flex items-center justify-center flex-col md:space-x-4 md:flex-row" onSubmit={handleSubmit}>
        <div className="mb-4 w-full md:w-auto md:flex md:flex-col">
          <label>Report Type</label>
          <select className="mt-1 select w-full max-w-full md:max-w-xs font-medium border-2 border-indigo-500/100" required onChange={e => {setInputs(values => ({...values, id: e.target.value})); hideShowInput(e.target.value)}}>
            <option selected hidden disabled>Please select a report</option>
            <optgroup label="Country Reports">
              {reportInfo.map(data => {
                if(data.category == "Country") {
                  return (
                    <option value={data.id}>{data.id}: {data.reportName}</option>
                  )
                }
              })}
            </optgroup>
            <optgroup label="City Reports">
              {reportInfo.map(data => {
                if(data.category == "City") {
                  return (
                    <option value={data.id}>{data.id}: {data.reportName}</option>
                  )
                }
              })}
            </optgroup>
            <optgroup label="Capital Reports">
              {reportInfo.map(data => {
                if(data.category == "Capital City") {
                  return (
                    <option value={data.id}>{data.id}: {data.reportName}</option>
                  )
                }
              })}
            </optgroup>
            <optgroup label="Population Reports">
              {reportInfo.map(data => {
                if(data.category == "Population") {
                  return (
                    <option value={data.id}>{data.id}: {data.reportName}</option>
                  )
                }
              })}
            </optgroup>
            <optgroup label="World Population Reports">
              {reportInfo.map(data => {
                if(data.category == "World Population") {
                  return (
                    <option value={data.id}>{data.id}: {data.reportName}</option>
                  )
                }
              })}
            </optgroup>
            <optgroup label="Language Reports">
              {reportInfo.map(data => {
                if(data.category == "Language") {
                  return (
                    <option value={data.id}>{data.id}: {data.reportName}</option>
                  )
                }
              })}
            </optgroup>
          </select>
        </div>
        
        <div style={{display: 'none'}} className="mb-4 md:w-auto w-full">
          <label>{labels.labelOne}</label>
          <input className="mt-1 input w-full max-w-full md:max-w-xs border-2 border-indigo-500/100 re" onChange={(e) => setInputs(values => ({...values, userInput1: e.target.value}))} type="text" id="input1" disabled required/>
        </div>

        <div style={{display: 'none'}} className="mb-4 md:w-auto w-full">
          <label>{labels.labelTwo}</label>
          <input className="mt-1 input w-full max-w-full md:max-w-xs border-2 border-indigo-500/100 re" onChange={(e) => setInputs(values => ({...values, userInput2: e.target.value}))} type="text" id="input2" disabled required/>
        </div>

        <div className="mt-2.5 w-full md:w-auto">
          <button className="btn btn-success w-full md:w-auto" type="submit">Generate</button>
        </div>

      </form>
    </div>
  );
}

export default InputsBar;
