package com.example.alumnismartconnect;

public class User {
    String FullName,UserName,Phone,Password,Email,YearOfPassOut,WorkingPlace,Designation,Briefing;
    public User(){};
    public User(String fullName,String userName,String phone,String password,String email,String yearOfPassOut,String workingPlace,String designation,String briefing){
        this.FullName=fullName;
        this.UserName=userName;
        this.Phone=phone;
        this.Password=password;
        this.Email=email;
        this.YearOfPassOut=yearOfPassOut;
        this.WorkingPlace=workingPlace;
        this.Designation=designation;
        this.Briefing=briefing;
    }


    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getYearOfPassOut() {
        return YearOfPassOut;
    }

    public void setYearOfPassOut(String yearOfPassOut) {
        YearOfPassOut = yearOfPassOut;
    }

    public String getWorkingPlace() {
        return WorkingPlace;
    }

    public void setWorkingPlace(String workingPlace) {
        WorkingPlace = workingPlace;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    public String getBriefing() {
        return Briefing;
    }

    public void setBriefing(String briefing) {
        Briefing = briefing;
    }
}
