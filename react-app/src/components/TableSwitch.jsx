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
          case '1':
          case '2':
          case '3':
          case '4':
          case '5':
          case '6':
            return (
              <CountryReport tableData={tableData}/>
            );

          case '7':
          case '8':
          case '9':
          case '10':
          case '11':
          case '12':
          case '13':
          case '14':
          case '15':
          case '16':
            return (
              <CityReport tableData={tableData}/>
            );

          case '17':
          case '18':
          case '19':
          case '20':
          case '21':
          case '22':
            return (
              <CapitalReport tableData={tableData}/>
            );

          case '23': 
            return (
              <PopulationReportContinent tableData={tableData}/>
            );

          case '24': 
            return (
              <PopulationReportRegion tableData={tableData}/>
            );

          case '25': 
            return (
              <PopulationReportCountry tableData={tableData}/>
            );

          default:
            return (
              <p>Nothing found</p>
            );
        }
      })()}
    </div>
  );
}
