export default function WorldPopulationReport({ tableData }) {
    return (
        <div className="overflow-x-auto">
            <table className="table table-zebra w-full">
                <thead>
                    <tr>
                        <td>Name</td>
                        <td>Population</td>
                    </tr>
                </thead>
                <tbody>
                    {tableData.map(data => {
                        return (
                            <tr>
                                <td>{data.name}</td>
                                <td>{data.totalPopulation}</td>
                            </tr>
                        )
                    })}
                </tbody>
            </table>
        </div>
    )
}