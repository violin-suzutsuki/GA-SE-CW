export default function CityReport({tableData}) {
    return (
        <table>
            <tr>
                <th>Name</th>
                <th>Country</th>
                <th>Population</th>
            </tr>
            {tableData.map(data => {
                if (data.capital !== null) {
                return (
                    <tr>
                    <td>{data.capital.name}</td>
                    <td>{data.name}</td>
                    <td>{data.capital.population}</td>
                    </tr>
                )
                }
            }
            )}
        </table>
    )
}