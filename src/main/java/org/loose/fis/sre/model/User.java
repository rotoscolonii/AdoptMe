package org.loose.fis.sre.model;

import javafx.scene.control.PasswordField;
import org.dizitart.no2.objects.Id;

import javax.validation.OverridesAttribute;

public class User {
    @Id
    private String name;
    private String password;
    private String password2;
    private String phonenum;
    private String email;
    private String role;

    public User(String name, String password, String password2, String phonenum, String email, String role) {
        this.name = name;
        this.password = password;
        this.password2 = password2;
        this.phonenum = phonenum;
        this.email = email;
        this.role = role;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phonenum;
    }

    public void setPhoneNum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (password2 != null ? !password2.equals(user.password2) : user.password2 != null) return false;
        if (phonenum != null ? !phonenum.equals(user.phonenum) : user.phonenum != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        return role != null ? role.equals(user.role) : user.role == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (password2 != null ? password2.hashCode() : 0);
        result = 31 * result + (phonenum != null ? phonenum.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }
}
