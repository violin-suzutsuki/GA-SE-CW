import CapitalReport from "./CapitalReport";
import CountryReport from "./CountryReport";
import CityReport from "./CityReport";

export default function TableSwitch({ tableData, tableTpl, isLoading }) {

  if (isLoading == true) {
    return (<p>Loading...</p>)
  }

  return (
    <div>
      {(() => {
        switch (tableTpl) {
          case '22':
          case '25':
            return (
              <CountryReport tableData={tableData}/>
            );

          case '24':
            return (
              <CapitalReport tableData={tableData}/>
            );

          case '23':
            return (
              <CityReport tableData={tableData}/>
            )

          default:
            return (
              <p>Please select a report from the dropdown.</p>
            );
        }
      })()}
    </div>
  );
}
