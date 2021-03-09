package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ToString
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DEPARTMENT")
public class Department {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "HEAD_OF_DEPARTMENT")
    private String headOfDepartment;

    @Column(name = "DEPARTMENT_NAME")
    private String departmentName;

    @ManyToMany
    @JoinTable(
            name = "DEPARTMENT_LECTORS",
            joinColumns = {@JoinColumn(name = "DEPARTMENT_ID")},
            inverseJoinColumns = {@JoinColumn(name = "LECTOR_ID")}
    )
    private List<Lector> lectors = new ArrayList<>();


}
