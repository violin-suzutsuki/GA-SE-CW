import Sidebar from "./components/Sidebar";
import Table from "./components/Table";
import { useState } from "react";
import React from "react";

export default function App() {
  const [data, setData] = useState([]);

  return (
    <>
      <Sidebar setTableData={setData} />
      <Table tableData={data} />
    </>
  );
}
