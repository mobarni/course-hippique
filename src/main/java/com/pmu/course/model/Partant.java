package com.pmu.course.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Partant {
    @Id
    private UUID id;

    private Integer numero;

    @NotEmpty(message= "nom may not be empty")
    private String nom;

}
