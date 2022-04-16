import Sidebar from "./components/Sidebar";
import Table from "./components/Table";
import { useState } from "react";
import React from "react";

export default function App() {
  const [data, setData] = useState([]);
  const [tableTpl, setTableTpl] = useState([]);
  const [loading, setLoading] = useState(false)

  return (
    <>
      <Sidebar setTableData={setData} setTableTpl={setTableTpl} setLoading={setLoading}/>
      <Table tableData={data} tableTpl={tableTpl} isLoading={loading}/>
    </>
  );
}
