export default function LanguageReport({ tableData }) {
    return (
        <div className="overflow-x-auto">
            <table className="table table-zebra w-full">
                <thead>
                    <tr>
                        <td>Language</td>
                        <td>Number of speakers</td>
                        <td>Percentage of world population</td>
                    </tr>
                </thead>
                <tbody>
                    {tableData.map(data => {
                        return (
                            <tr>
                                <td>{data.language}</td>
                                <td>{data.population}</td>
                                <td>{data.percentOfWorld}</td>
                            </tr>
                        )
                    })}
                </tbody>
            </table>
        </div>
    )
}