package com.pmu.course.model;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Table(uniqueConstraints =
        { //other constraints
                @UniqueConstraint(name = "UniqueNumberAndDate", columnNames = { "nom", "numero", "date" })})
public class Course {
    @Id
    private UUID id;

    private Integer numero;

    private String nom;

    private LocalDate date;

    @ManyToMany
    @Size.List({ @Size(min = 3)})
    private Set<Partant> partants;

}
