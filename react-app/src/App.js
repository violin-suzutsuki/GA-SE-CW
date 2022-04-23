import Header from "./components/Header";
import Footer from "./components/Footer";
import InputsBar from "./components/InputsBar";
import TableSwitch from "./components/TableSwitch";
import { useState } from "react";
import React from "react";

export default function App() {
  const [data, setData] = useState([]);
  const [tableTpl, setTableTpl] = useState([]);
  const [loading, setLoading] = useState(false)

  return (
    <>
      <div className="main px-10 md:px-20">
        <Header id={tableTpl}/>
        <InputsBar setTableData={setData} setTableTpl={setTableTpl} setLoading={setLoading}/>
        <TableSwitch tableData={data} tableTpl={tableTpl} isLoading={loading}/>
      </div>
      <Footer/>
    </>
  );
}
