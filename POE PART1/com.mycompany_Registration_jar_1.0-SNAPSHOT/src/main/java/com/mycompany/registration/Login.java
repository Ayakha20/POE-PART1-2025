package com.mycompany.registration;

public class Login {
    //Attributes - Store data about the User
    private String firstName;
    private String lastName;
    private String username;
    private String Password;
    private String phoneNumber;
    
    //Constructor - Intializes the object with values
    public Login(String firstName, String lastName, String UserName, String Password, String PhoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.Password = Password;
        this.phoneNumber = phoneNumber;
    }
    //Methods - Define the behaviors or actions of the class
    public boolean checkUserName() {
        return username.contains("_") && username.length () <=5;     
    }
    public boolean checkPasswordComplexity(String Password) {
        boolean hasLength = Password.length() >=8;
        boolean hasUppercase = Password.matches(".*[A-Z].*");
        boolean hasNumber = Password.matches(".*[0-9].*");
        boolean hasSpecialChar = Password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
        return hasLength && hasUppercase && hasNumber && hasSpecialChar;
    }
    public boolean checkPhoneNumber() {
        boolean startsWithCode = phoneNumber.startsWith("+27");
        boolean correctLength = phoneNumber.length() == 12;
        return startsWithCode && correctLength;
    }
    public String registerUser() {
        if(checkUserName()) {
            return "The username is incorrectly formatted";   
        } else if (! checkPasswordComplexity(Password)) {
            return "The password does not meet the complexity requirements";
        } else if (!checkPhoneNumber()) {
            return "The phone number is invalid";
        } else {
            return "The user has been registered successfully";
        }
    }
    public boolean loginUser(String enteredUsername, String enteredPassword) {
        return this.username.equals(enteredUsername) && this.Password.equals(enteredPassword); 
    }
    public String returnLoginStatus(String enteredUserName, String enteredPassword) {
        if(loginUser (enteredUserName, enteredPassword)) {
            return "Welcome" + this.firstName + " " + this.lastName + ", it is great to see you again";
        }else {
            return "UserName or password is incorrect, please try again";
        }
    }
    }

    

