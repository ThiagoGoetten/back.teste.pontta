package pontta.teste.crud.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Table(name = "users")
@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "dateOfBirth")
    private LocalDate dateOfBirth;

}
