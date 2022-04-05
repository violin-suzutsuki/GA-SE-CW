export default function Table({ tableData, reportId, isLoading }) {

  if (isLoading == true) {
    return (<p>Loading...</p>)
  }

  return (
    <div>
      {(() => {
        switch (reportId) {
          case '22':
          case '25':
            return (
              <table>
                <tr>
                  <th>Code</th>
                  <th>Name</th>
                  <th>Continent</th>
                  <th>Region</th>
                  <th>Population</th>
                  <th>Capital</th>
                </tr>
                {tableData.map(data => (
                  <tr>
                    <td>{data.code}</td>
                    <td>{data.name}</td>
                    <td>{data.continent}</td>
                    <td>{data.region}</td>
                    <td>{data.population}</td>
                    <td>{(data.capital == null) ? "-" : data.capital.name}</td>
                  </tr>
                ))}
              </table>
            );

          case '24':
            return (
              <table>
                <tr>
                  <th>Name</th>
                  <th>Country</th>
                  <th>District</th>
                  <th>Population</th>
                </tr>
                {tableData.map(data => 
                  {return data.districts.map(d => 
                    {return d.cities.map(c => (
                      <tr>
                        <td>{c.name}</td>
                        <td>{data.name}</td>
                        <td>{c.district}</td>
                        <td>{c.population}</td>
                      </tr>
                    ))}
                  )}
                )}
              </table>
            );

          case '23': 
            return (
              <table>
                <tr>
                  <th>Name</th>
                  <th>Country</th>
                  <th>Population</th>
                </tr>
                {tableData.map(data => 
                  {if(data.capital !== null) {
                    return(
                    <tr>
                      <td>{data.capital.name}</td>
                      <td>{data.name}</td>
                      <td>{data.capital.population}</td>
                    </tr>)
                  }}
                )}
              </table>
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