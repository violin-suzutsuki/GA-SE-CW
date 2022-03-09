package com.SET08103.cw;

import com.SET08103.cw.data.DataHandler;
import com.SET08103.cw.objects.Continent;
import com.SET08103.cw.objects.Country;
import com.SET08103.cw.objects.Region;

import java.sql.*;
import java.util.ArrayList;

/**
 * App.java
 *
 * This is the program entrypoint and contains code to connect to an SQL docker container.
 */
public class App
{
    public static void main(String[] args)
    {
        System.out.println("[*] Establishing connection to SQL database...");

        long Start = System.currentTimeMillis();

        DataHandler dataHandler = new DataHandler();
        boolean result = dataHandler.connect(100);

        if (result == false)
        {
            System.out.println("[-] Failed to connect to the database.");
            return;
        }

        System.out.println(String.format("[+] Established connection to the database! Took %sms", System.currentTimeMillis() - Start));

        dataHandler.loadContinents();

        for (Continent continent : dataHandler.getContinents())
        {
            for (Region region : continent.getRegions())
            {
                for (Country country : region.getCountries())
                {
                    System.out.println(String.format("%s - %s: %s", continent.getName(), region.getName(), country.toString()));
                }
            }
        }
    }
}
