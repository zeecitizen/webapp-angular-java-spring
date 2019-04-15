# webapp-angular-java-spring - [work in progress]
Backend and Frontend for a web application that lets you search on Google places and book a property

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

## Results
- Frontend and backend running on a local machine should be able to communicate


## Introduction
An app to show properties around a user location and few details.


## Requirements:
Requirements for the app are:
- Make sure there's a list, which lets you see/find any property around your current location.
- Make sure the user can select a specific property, and create a "fake" booking request.
- Show the booking requests list with a public API.

## Features:
- Google Places API is used given at https://developer.here.com/documentation/places/topics/what-is.html
- Angular is used for Frontend and Java Spring is used for backend. 
