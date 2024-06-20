package com.sesion.dominio;
 // @author FabianCol
import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;


@Data
@Entity
@Table(name = "user")
public class Usuario implements Serializable{
       
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    private String nameUser;
    private String lastnameUser;
    private String phoneUser;
    private String emailUser;
    
}
