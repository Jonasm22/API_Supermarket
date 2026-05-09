package org.example.supermercadoapi.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "BRANCHES")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BRANCH_ID")
    private Long id;

    @NotBlank
    @Size(max = 150)
    @Column(name = "BRANCH_NAME", nullable = false , length = 150)
    private String name;

    @NotBlank
    @Size(max = 255)
    @Column(name = "BRANCH_ADDRESS", nullable = false, length = 255)
    private String address;

    @NotBlank
    @Size(max = 20)
    @Column(name = "BRANCH_TELEPHONE_NUMBER", nullable = false, length = 20, unique = true)
    private String telephoneNumber;


}
