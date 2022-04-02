export default function Table({ tableData, reportId, isLoading }) {

  if (isLoading == true) {
    return (<p>Loading...</p>)
  }

  return (
    <div>
      {(() => {
        switch (reportId) {
          case '22':
          case '23':
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
                    <td>{(data.capital == null) ? "No Data" : data.capital.name}</td>
                  </tr>
                ))}
              </table>
            );

          case '24':
            return (
              <table>
                <tr>
                  <th>2</th>
                  <th>4</th>
                  <th>6</th>
                  <th>8</th>
                </tr>
                {tableData.map(data => (
                  <tr>
                    <td>{data.code}</td>
                    <td>{data.code}</td>
                    <td>{data.code}</td>
                    <td>{data.code}</td>
                  </tr>
                ))}
              </table>
            );

          default:
            return (
              <p>Please select a report from the dropdown.</p>
            );
        }
      })()}
    </div>
  );
}