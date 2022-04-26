export default function CountryReport({tableData}) {
    return (
        <div className="overflow-x-auto mb-7">
            <table className="table table-zebra w-full">
                <thead>
                    <tr>
                        <th>Code</th>
                        <th>Name</th>
                        <th>Continent</th>
                        <th>Region</th>
                        <th>Population</th>
                        <th>Capital</th>
                    </tr>
                </thead>
                <tbody>
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
                </tbody>
            </table>
        </div>
    )
}
