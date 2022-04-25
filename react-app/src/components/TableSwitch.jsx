import CapitalReport from "./CapitalReport";
import CountryReport from "./CountryReport";
import CityReport from "./CityReport";
import PopulationReportContinent from "./PopulationReportContinent";
import PopulationReportCountry from "./PopulationReportCountry";
import PopulationReportRegion from "./PopulationReportRegion";

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
          case '28':
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
            );

          case '26': 
            return (
              <PopulationReportContinent tableData={tableData}/>
            );

          case '29': 
            return (
              <PopulationReportRegion tableData={tableData}/>
            );

          case '45': 
            return (
              <PopulationReportCountry tableData={tableData}/>
            );

          default:
            return (
              <p></p>
            );
        }
      })()}
    </div>
  );
}
