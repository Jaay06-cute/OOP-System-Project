# [DEVELOPER] UM LIBRARY MANAGEMENT SYSTEM

## GENERAL COMMIT FORMAT
You should format your comments in the UI like this:

UI/SQL/Code - '' Name '' - Updated
<br>
'' Package Path ''
<br>
'' Update Description ''

## FUTURE CODING GOALS
- [ ] USER INTERFACE
  - [x] [July 1, 2025] Student
    - [ ] Sign up & Log in
      - [ ] Sync up with SQL (to save your Student's data into the server)
      - [ ] Check if the details are complete/valid/correct in Sign Up
      - [ ] Authenticate if the email/id number are valid in SQL
    - [ ] Profile
      - [ ] Sync with SQL Sign In Info
      - [ ] Return books info in the page
    - [ ] Reservation
      - [ ] Books should be generated based on SQL
      - [ ] Books interactions & buttons
      - [ ] Books update based on SQL
    - [ ] Favorites '' generate the page ''
    - [ ] Notification '' generate the page ''
    - [ ] History '' generate the page ''
    - [ ] Signout '' generate the page ''
  - [ ] Admin

## GENERAL GITHUB NOTES

## HOW TO SET UP SERVER

## HOW AUTHENTICATION WORKS 
Use Regex library to check whether the user gets access to the system (regex the string "@umindanao.edu.ph" + check if the idNumber is not null to get access)  
FOLLOW INSTRUCTIONS FROM THIS LINK: https://www.w3schools.com/java/java_regex.asp
