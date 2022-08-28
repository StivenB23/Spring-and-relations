package com.sena.learnspringboot.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45, nullable =false)
    private String email;

    @Column(length = 10, nullable=false)
    private String password;

    @ManyToMany(cascade = CascadeType.PERSIST,fetch= FetchType.EAGER)
    @JoinTable(name="usuario_rol", 
    joinColumns= @JoinColumn(name="usuario_id"), 
    inverseJoinColumns = @JoinColumn(name="rol_id"))
    private List<Rol> roles = new ArrayList<>();

    

    public Usuario() {
    }


    public Usuario( String email, String password, List<Rol> roles) {
        this.email = email;
        this.password = password;
        this.roles = roles;
    }


    public Usuario(Integer id, String email, String password, List<Rol> roles) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public void addRol(Rol rol){
       this.roles.add(rol);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }


    @Override
    public String toString() {
        return "[roles=" + roles + "]";
    }
    
}
