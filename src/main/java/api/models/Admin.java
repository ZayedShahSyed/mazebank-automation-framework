package api.models;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Admin {
    private String role;
    private long adminId;
    private String fullName;
    private String token;

    public Admin() {
    }

    public Admin(String role, long adminId, String fullName, String token) {
        this.role = role;
        this.adminId = adminId;
        this.fullName = fullName;
        this.token = token;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public long getAdminId() {
        return adminId;
    }

    public void setAdminId(long adminId) {
        this.adminId = adminId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
