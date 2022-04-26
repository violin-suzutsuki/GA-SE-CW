export default function CapitalReport({ tableData }) {
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
                        if (data !== null) {
                        return (
                            <tr>
                                <td>{data.name}</td>
                                <td>{data.countryCode}</td>
                                <td>{data.population}</td>
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
