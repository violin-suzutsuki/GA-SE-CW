Use case:  Produce a report on cities

Goal in Context
As a customer of the company
I want to generate a range of reports that include requested statistics about a given city
So that I can access and utilise this data at any time

Scopes
The company.

Level
Primary task.

Preconditions
Database contains sufficient and accurate data for cities of each country in the world.  
Java application has access to this data through SQL queries.
Requested data can be pulled through and displayed on a web application.

Success End Condition
The customer has the ability to generate one or more of these reports:
•	All the cities in the world organised by largest population to smallest.
•	All the cities in a continent organised by largest population to smallest.
•	All the cities in a region organised by largest population to smallest.
•	All the cities in a country organised by largest population to smallest.
•	All the cities in a district organised by largest population to smallest.
•	The top N populated cities in the world where N is provided by the user.
•	The top N populated cities in a continent where N is provided by the user.
•	The top N populated cities in a region where N is provided by the user.
•	The top N populated cities in a country where N is provided by the user.
•	The top N populated cities in a district where N is provided by the user.

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


