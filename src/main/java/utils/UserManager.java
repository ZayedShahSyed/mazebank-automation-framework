package utils;

public class UserManager {
    public String role;
    public String email;
    public String fullName;
    public long customerId;
    public String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserManager() {
    }

    public void setUser(UserManager o){
        this.role = o.getRole();
        this.email = o.getEmail();
        this.fullName = o.fullName;
        this.customerId = o.customerId;
        this.token = o.getToken();
    }

    public UserManager getUser(){
        return this;
    }


    public UserManager(String role, String email, String fullName, long customerId,String token) {
        this.role = role;
        this.email = email;
        this.fullName = fullName;
        this.customerId = customerId;
        this.token = token;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
}
