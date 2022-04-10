import React from "react";
import { useState } from "react";

function Sidebar({ setTableData, setInputs, inputs, setLoading }) {
  // setTableData is from the App
  const getData = (id) => {
    setLoading(true)
    const responseFromAPI = fetch(`/api/report?reportId=${id}`)
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

  // const getValueFromSelect = (e) => {
  //   const selectValue = e.target.value;
  //   console.log(selectValue);
  // };

  return (
    <>
      SIDEBAR
      <button onClick={() => getData(inputs.id)}>Generate</button>
      <select onChange={(e) => setInputs(values => ({...values, id: e.target.value}))}>
        <option value="22">22</option>
        <option value="23">23</option>
        <option value="24">24</option>
      </select>
      <input id="userInput" type="text" />
    </>
  );
}

export default Sidebar;