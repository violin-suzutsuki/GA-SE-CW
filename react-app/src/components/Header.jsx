import headerData from '../header.json'

export default function Header({ id }) {
    
    if(id.length == 0) {
        return (
            <>
                <div>
                    <h1>No report selected</h1>
                    <p>To get started select a report from the dropdown</p>
                </div>
                <div>
                    <img src="/inky-settings-1.png" alt="test" />
                </div>
            </>
        )
    } else {
        return (
            <>
                {headerData.map(header => {
                    if(header.id == id) {
                        return (
                            <div className='grid grid-cols-2'>
                                <div className='flex flex-col justify-center'>
                                    <h1 className="text-4xl tracking-tight font-extrabold text-gray-900 sm:text-5xl md:text-6xl">
                                        <span className="block xl:inline">{header.reportName}</span>{' '}
                                        <span className="block text-indigo-600 xl:inline">Id - {header.id}</span>
                                    </h1>
                                    <p className="mt-3 text-base text-gray-500 sm:mt-5 sm:text-lg sm:max-w-xl sm:mx-auto md:mt-5 md:text-xl lg:mx-0">{header.description}</p>
                                </div>
                                <div>
                                    <img src="/inky-settings-1.png" alt="test" />
                                </div>
                            </div>
                        )
                    }
                })}
            </>
        )
    }
}