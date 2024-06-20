package com.sesion.dominio;
// @author FabianCol

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @NotEmpty
    private String nameUser;
    @NotEmpty
    private String lastnameUser;
    @NotEmpty
    private String phoneUser;
    
    @NotEmpty
    @Email
    private String emailUser;
    
}
