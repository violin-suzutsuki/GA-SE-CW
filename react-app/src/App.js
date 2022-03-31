import Sidebar from "./components/Sidebar";
import Table from "./components/Table";
import { useState } from "react";
import React from "react";

export default function App() {
  const [data, setData] = useState([]);
  const [id, setReportId] = useState([]);
  const [loading, setLoading] = useState(false)

  return (
    <>
      <Sidebar setTableData={setData} setId={setReportId} setLoading={setLoading}/>
      <Table tableData={data} reportId={id} isLoading={loading}/>
    </>
  );
}
