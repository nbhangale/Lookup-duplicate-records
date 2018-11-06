# Duplicate Record Identifier Using Spring Boot Integrated with React-Redux

Spring boot server integrated with React-Redux Client

A Sample Duplicate Record separated where employee data can be separated based on Levenshtein Distance measure.

Implementations:
Server: Spring boot
Client: React with redux

Below are the steps to start the application on tomcat server:
Easily acecessible at 'https://blooming-eyrie-63560.herokuapp.com/lookup' and 'https://blooming-eyrie-63560.herokuapp.com/nonduplicate'

1. Download the project folder (copy the same to local file)
2. Import SpringBootServer directory as 'Existing Maven Repository' in STS/Eclips/IntelliJ
3. Run as 'Maven Install'
4. Run as 'Junit Test'
5. Run as 'Spring Boot App' (You will be able to access the server at ('http://localhost:8081') )
6. Send POST request 'http://localhost:8081/lookup' in Postman with Body as 'form-data': Key 'file', Value 'csv file path', list shows non-duplicate records at 0th key index and duplicate sets on other key index apart from 0.
7. To get non-duplicate records, Send POST request 'http://localhost:8081/nonduplicate' in Postman with Body as 'form-data': Key 'file', Value 'csv file path' 


Below are the steps to start the react app:
1. Open the terminal for Lookup-duplicate-records\ReactJSClient\findduplicatesui and run 
  ```
  yarn install / npm install
  ```
  ```
  yarn start / npm start
  ```
2. You can access the web app at 'http://localhost:3000/'

