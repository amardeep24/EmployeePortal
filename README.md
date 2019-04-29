# EmployeePortal
This is a Angular 7 app with a SpringBoot REST-API backend for storing and viewing employees.

## Prerequisite:

 - Gradle 4.1+ 
 - JDK 8+
 - Node 10+
 - Git & Git Bash

## Checkout

To check out the project open git bash and type:
`git clone https://github.com/amardeep24/EmployeePortal.git`

## Running the Spring-Boot REST API

To run the Spring-Boot REST-API, go into the root directory and open a terminal and there type:
`gradle bootRun`

## Running the Angular UI:

To run the Angular app, go into the `src/client/angular` directory and open a terminal and there type:
 - `npm install`
 - `ng serve`
Then open Google Chrome, navigate to http://localhost:4200

 - In the UI, the top section will show a paginated view of all the employees registered.
 - The bottom half will be a form t o register new employees.

![Application UI](https://user-images.githubusercontent.com/17095403/56878518-21f48600-6a72-11e9-9b82-30deb27588d2.png)



