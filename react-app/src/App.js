import Sidebar from "./components/Sidebar";
import TableSwitch from "./components/TableSwitch";
import { useState } from "react";
import React from "react";

export default function App() {
  const [data, setData] = useState([]);
  const [tableTpl, setTableTpl] = useState([]);
  const [loading, setLoading] = useState(false)

  return (
    <>
      <Sidebar setTableData={setData} setTableTpl={setTableTpl} setLoading={setLoading}/>
      <TableSwitch tableData={data} tableTpl={tableTpl} isLoading={loading}/>
    </>
  );
}
