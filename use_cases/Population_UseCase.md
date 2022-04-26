Use case:  Produce a report on population

Goal in Context
As a customer of the company
I want to generate a range of reports that include requested statistics about the population of a world/continent/region/country
So that I can access and utilise this data at any time

Scopes
The company.

Level
Primary task.

Preconditions
Database contains sufficient and accurate data for countries of the world.  
Java application has access to this data through SQL queries.
Requested data can be pulled through and displayed on a web application.

Success End Condition
The customer has the ability to generate one or more of these reports:
•	The population of people, people living in cities, and people not living in cities in each continent.
•	The population of people, people living in cities, and people not living in cities in each region.
•	The population of people, people living in cities, and people not living in cities in each country.
•	The population of the world.
•	The population of a continent.
•	The population of a region.
•	The population of a country.
•	The population of a district.
•	The population of a city.

Failed End Condition
The customer cannot generate any of the above reports.
Primary Actor
The customer.

Trigger
A customer selects a report from a list of options, button press to confirm, which then submits the request.

Main success scenario
Correct information from the database is successfully retrieved.
Requested data is sent to the front-end and displayed in the correct format within the User Interface.

Extensions
N/A.

Sub-variations
N/A.

Schedule
Version 1.0 (official release)


