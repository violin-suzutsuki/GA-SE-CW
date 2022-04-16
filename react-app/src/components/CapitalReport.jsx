export default function CapitalReport({tableData}) {
    return (
        <table>
            <tr>
                <th>Name</th>
                <th>Country</th>
                <th>District</th>
                <th>Population</th>
            </tr>
            {tableData.map(data => {
                return data.districts.map(d => {
                return d.cities.map(c => (
                    <tr>
                    <td>{c.name}</td>
                    <td>{data.name}</td>
                    <td>{c.district}</td>
                    <td>{c.population}</td>
                    </tr>
                ))
                }
                )
            }
            )}
        </table>
    )
}
