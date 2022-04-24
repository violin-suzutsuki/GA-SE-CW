export default function CityReport({tableData}) {
    return (
        <div className="overflow-x-auto mb-7">
            <table className="table table-zebra w-full">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Country</th>
                        <th>Population</th>
                    </tr>
                </thead>
                <tbody>
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
                </tbody>
            </table>
        </div>
    )
}
