import Sidebar from "./components/Sidebar";
import Table from "./components/Table";
import { useState } from "react";
import React from "react";

export default function App() {
  const [data, setData] = useState([]);
  const [inputs, setInputs] = useState({id: "", userInput: ""});
  const [loading, setLoading] = useState(false)

  return (
    <>
      <Sidebar setTableData={setData} setInputs={setInputs} inputs={inputs} setLoading={setLoading}/>
      <Table tableData={data} reportId={inputs.id} isLoading={loading}/>
    </>
  );
}
