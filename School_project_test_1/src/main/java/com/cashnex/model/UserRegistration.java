package com.cashnex.model;

public class UserRegistration {
    private int id;
    private String username;
    private String nrcNumber;
    private String userEmail;
    private String career;
    private String hashedPassword;
    private String accountNumber;
    private String otp;

    // Constructors
    public UserRegistration() {
    }

    public UserRegistration(String username, String nrcNumber, String userEmail, String career, String hashedPassword, String accountNumber, String otp) {
        this.username = username;
        this.nrcNumber = nrcNumber;
        this.userEmail = userEmail;
        this.career = career;
        this.hashedPassword = hashedPassword;
        this.accountNumber = accountNumber;
        this.otp = otp;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNrcNumber() {
        return nrcNumber;
    }

    public void setNrcNumber(String nrcNumber) {
        this.nrcNumber = nrcNumber;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}
