package com.example.sec13_01.entity;

import jakarta.persistence.*;

import java.sql.Blob;
import java.util.Collection;

@Entity
@Table(name="users")
public class User {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="username")
    private String username;
    @Column(name="password", length = 255)
    private String password;
    @Column(name="enabled")
    private boolean enabled;
    @Column(name="firstname")
    private String firstName;
    @Column(name="lastname")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Lob
    @Column(name="avatar")
    private Blob avartar;
    // ==> avartar's type ==> blobs (in SQL) ==> Can cover upto 65000 bytes
    // ==> with data having big size, we can use URL, base64, and bolds to save it in databe
/* ___ *Note* 13.1*/
    @ManyToMany(fetch = FetchType.EAGER, cascade =  CascadeType.ALL)
    @JoinTable(
            name="users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name="role_id")
    )
    private Collection<Role> roles;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", avartar=" + avartar +
                ", roles=" + roles +
                '}';
    }

    /*----------Getter, Setter --------*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Blob getAvartar() {
        return avartar;
    }

    public void setAvartar(Blob avartar) {
        this.avartar = avartar;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    /* ------ Constructor -------*/
    public User(String username, String password, boolean enabled, String firstName, String lastName, String email, Blob avartar) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.avartar = avartar;
    }

    public User(String username, String password, boolean enabled, String firstName, String lastName, String email, Blob avartar, Collection<Role> roles) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.avartar = avartar;
        this.roles = roles;
    }

    public User(Long id, String username, String password, boolean enabled, String firstName, String lastName, String email, Blob avartar, Collection<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.avartar = avartar;
        this.roles = roles;
    }

    public User() {
    }
}
