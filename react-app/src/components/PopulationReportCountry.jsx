export default function PopulationReportCountry({ tableData }) {
    return (
        <div className="overflow-x-auto">
            <table className="table table-zebra w-full">
                <thead>
                    <tr>
                        <th>Name (Country)</th>
                        <th>Total Population (Country)</th>
                        <th>Total Population Living In Cities (Country)</th>
                        <th>Total Population Living Not In Cities (Country)</th>
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