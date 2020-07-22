package ru.plotnikov.advboard.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String login;
    private String password;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    private Set<Role> roles;
}
