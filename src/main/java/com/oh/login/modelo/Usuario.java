/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oh.login.modelo;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Set;

/**
 *
 * @author Carlos OH Rivera
 */
@Entity
@Table(name="usuarios",uniqueConstraints = @UniqueConstraint(columnNames="email"))
public class Usuario {
    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY)
    private long id;
    @Column(name = "nombre",length = 100)
    private String nombre;
    @Column(name = "apellido",length = 100)
    private String apellido;
    @Column(name = "email",length = 150)
    private String email;
    @Column(name = "password",length = 50)
    private String password;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
@JoinTable(
        name = "usuarios_roles",
        joinColumns = @JoinColumn(
                name = "usuario_id",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(
                name = "rol_id",referencedColumnName = "id"
        )
)
    private Collection<Rol> roles;


    public Usuario(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public Collection<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Rol> roles) {
        this.roles = roles;
    }

    public Usuario(long id, String nombre, String apellido, String email, String password, Collection<Rol> roles) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public Usuario(String nombre, String apellido, String email, String password, Collection<Rol> roles) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public Usuario() {
        super();
    }
}
