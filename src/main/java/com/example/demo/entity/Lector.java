package com.example.demo.entity;

import com.example.demo.entity.type.Degree;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "LECTOR")
public class Lector {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "LECTOR_SALARY")
    private Double lectorSalary;

    @Enumerated(value = EnumType.STRING)
    private Degree degree;

    @ManyToMany(mappedBy = "lectors")
    private List<Department> departments = new ArrayList<>();

    @Override
    public String toString() {
        return "Lector{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", degree=" + degree +
                ", lectorsSalary=" + lectorSalary +
                '}';
    }
}
