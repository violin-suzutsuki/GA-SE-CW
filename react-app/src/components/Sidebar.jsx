import React from "react";
import { useState } from "react";

function Sidebar({ setTableData, setTableTpl, setLoading }) {
  const [inputs, setInputs] = useState({id: "", userInput: ""}) 

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

  const hideShowInput = () => {
    console.log(`hiding showing input`);
    // const userInput = document.getElementById("userInput");
    // userInput.classlist.add();
  };


  return (
    <>
      <button onClick={() => getData(inputs.id, inputs.userInput)}>Generate</button>
      <select onChange={(e) => setInputs(values => ({...values, id: e.target.value}))}>
        <option value="22">22</option>
        <option value="23">23</option>
        <option value="24">24</option>
      </select>
      <input onChange={(e) => setInputs(values => ({...values, userInput: e.target.value}))} type="text" />
    </>
  );
}

export default Sidebar;