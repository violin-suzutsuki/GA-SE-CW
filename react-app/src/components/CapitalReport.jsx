export default function CapitalReport({ tableData }) {
    return (
        <div className="overflow-x-auto mb-7">
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
                </tbody>
            </table>
        </div>
    )
}
