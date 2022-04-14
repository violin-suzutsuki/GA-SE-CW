import React from "react";
import { useState } from "react";

function Sidebar({ setTableData, setTableTpl, setLoading }) {
  const [inputs, setInputs] = useState({id: "1", userInput: ""}) 
  const customReports = ["3", "5", "6", "12", "13", "14", "15", "16", "21", "22", "23"]

  // setTableData is from the App
  const getData = (id, userInput) => {
    setTableTpl(id)
    setLoading(true)
    const responseFromAPI = fetch(`/api/report?reportId=${id}&userInput=${userInput}`)
      .then((response) => response.json())
      .then((responseJSON) => {
        // do stuff with responseJSON here...
        console.log(responseJSON);
        setTableData(responseJSON);
        
      });
    setLoading(false);
  };

  const hideShowInput = (id) => {
    var input = document.getElementById("input");
    input.disabled = !customReports.includes(id) 
  };

  const handleSubmit = Event => {
    Event.preventDefault();
    getData(inputs.id, inputs.userInput)
    document.getElementById("input").value="";
  }

  return (
    <form onSubmit={handleSubmit}>
      <select onChange={e => {setInputs(values => ({...values, id: e.target.value})); hideShowInput(e.target.value)}}>
        <optgroup label="Country Report">
          <option value="22">22</option>
        </optgroup>
        <optgroup label="City Report">
          <option value="23">23</option>
        </optgroup>
        <optgroup label="Capital Report">
          <option value="24">24</option>
        </optgroup>
        <optgroup label="Population Report">
          <option value="25">25</option>
        </optgroup>
      </select>
      <input onBlur={(e) => setInputs(values => ({...values, userInput: e.target.value}))} type="text" id="input" disabled/>
      <button type="submit">Generate</button>
    </form>
  );
}

export default Sidebar;