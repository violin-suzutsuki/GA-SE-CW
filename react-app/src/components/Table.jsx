export default function Table({ tableData, reportId }) {
    return (
      <div>
      {(() => {

        switch (reportId) {
          case '22':
            return (
              <table>
                <tr>
                  <th>1</th>
                  <th>2</th>
                  <th>3</th>
                  <th>4</th>
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

            case '23':
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
            return(
              <p>Please select a report from the dropdown.</p>
            );
        }
      })()}
    </div>
    );
}