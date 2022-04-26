export default function PopulationReportRegion({ tableData }) {
    return (
        <div className="overflow-x-auto">
            <table className="table table-zebra w-full">
                <thead>
                    <tr>
                        <th>Name (Region)</th>
                        <th>Total Population (Region)</th>
                        <th>Total Population Living In Cities (Region)</th>
                        <th>Total Population Living Not In Cities (Region)</th>
                    </tr>
                </thead>
                <tbody>
                    {tableData.map(data => {
                        return(
                            <tr>
                                <td>{data.name}</td>
                                <td>{data.totalPopulation}</td>
                                <td>{data.populationInCities}</td>
                                <td>{data.populationNotInCities}</td>
                            </tr>
                        )
                    }
                    )}
                </tbody>
            </table>
        </div>
    )
}