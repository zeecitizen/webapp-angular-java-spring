# webapp-angular-java-spring
Backend and Frontend for a web application that lets you search on Google places and book a property


## Introduction
An app to show properties around a user location and few details.

## What does the app do?
Requirements specification includes:
- Making sure there's a list, which lets us see/find any property around our current location.
- Making sure the user can select a specific property, and create a booking request.
- Show the booking requests list with a public API.

## Features:
- Google Places API is used given at https://developer.here.com/documentation/places/topics/what-is.html
- Angular is used for Frontend and Java Spring is used for backend. 

## Results
- Frontend and backend running on a local machine should be able to communicate


# Where to Find Code Files in this project? 
## BACKEND
The backend has been upgraded recently to use PostGres instead of H2 inmemory databases and code classes can be seen here: 

Properly implemented repository class:
https://github.com/zeecitizen/webapp-angular-java-spring/blob/master/backend/src/main/java/limeapp/model/dao/PostgresBookingRepositry.java 
 
Proper interfaces: 
https://github.com/zeecitizen/webapp-angular-java-spring/blob/master/backend/src/main/java/limeapp/model/dao/BookingRepository.java 

A controller class to call model and daos to talk to PostGres:
https://github.com/zeecitizen/webapp-angular-java-spring/blob/master/backend/src/main/java/limeapp/controller/BookingController.java 

A service class to help create bookings:
https://github.com/zeecitizen/webapp-angular-java-spring/blob/master/backend/src/main/java/limeapp/service/BookingService.java

Proper tests:
https://github.com/zeecitizen/webapp-angular-java-spring/blob/master/backend/src/test/java/limeapp/BookingControllerTests.java  

## FRONTEND classes can be seen here: 

Displaying of places fetched from Google Places API:
https://github.com/zeecitizen/webapp-angular-java-spring/blob/master/frontend/places-list/src/app/places-search/places-search.component.html 

Places searching component:
https://github.com/zeecitizen/webapp-angular-java-spring/blob/master/frontend/places-list/src/app/places-search/places-search.component.ts 

Interface to represent the data model:
https://github.com/zeecitizen/webapp-angular-java-spring/blob/master/frontend/places-list/src/app/bookings.ts
https://github.com/zeecitizen/webapp-angular-java-spring/blob/master/frontend/places-list/src/app/nearby-places.ts  

Service to do places search: 
https://github.com/zeecitizen/webapp-angular-java-spring/blob/master/frontend/places-list/src/app/places-search.service.ts  

# RUNNING THE APPLICATION

## Running the application Frontend
Run Visual Studio Code

Open the Command Palette (Ctrl+Shift+P)   
Then type 'shell command'   
Then select first Shell "Run" command  
Next go to this new window terminal   
cd into folder in which code exists  
Type command 'code .' code [space] [dot] in terminal.  
This will open vs code in the angular code directory ready to inspect and run code!   
Now run command in vscode powershell in a new Terminal: npm install  
Next you can npm install required packages indicated as missing. In the end run this command to run the app: ng serve --open  

## Running the application Backend
Import as maven project to IntelliJ Idea and run the tests / main application. 

## Config
- Usually we'd need to run some SQL scripts to create a database in Java Spring using the schema. However, here we're using an in-memory H2 database.
- The backend has been upgraded recently to use PostGres instead of H2 inmemory databases and code classes can be seen here: 
