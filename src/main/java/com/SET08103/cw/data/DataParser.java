package com.SET08103.cw.data;

/**
 * DataHandler.java
 *
 * This is the class that handles parsing the in-memory sql objects. It is responsible for generating the data used for reports.
 */
public class DataParser {
    private DataHandler dataHandler;

    /**
     * Constructor for the DataParser class
     *
     * @param dataHandler SQL data handler used in the class methods.
     */
    public DataParser(DataHandler dataHandler)
    {
        this.dataHandler = dataHandler;
    }
}
