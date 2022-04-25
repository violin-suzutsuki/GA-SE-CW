export default function CityReport({tableData}) {
    return (
        <div className="overflow-x-auto">
            <table className="table table-zebra w-full">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Country</th>
                        <th>District</th>
                        <th>Population</th>
                    </tr>
                </thead>
                <tbody>
                    {tableData.map(data => {
                        return (
                        <tr>
                            <td>{data.name}</td>
                            <td>{data.countryCode}</td>
                            <td>{data.district}</td>
                            <td>{data.population}</td>
                        </tr>
                        )
                    }
                    )}
                </tbody>
            </table>
        </div>
    ) 
}
