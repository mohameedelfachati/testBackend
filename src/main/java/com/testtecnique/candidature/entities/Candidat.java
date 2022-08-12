package com.testtecnique.candidature.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "candidat")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Candidat {
    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(name = "sequence-generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @org.hibernate.annotations.Parameter(name = "sequence_name", value = "user_sequence"),
            @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"), @org.hibernate.annotations.Parameter(name = "increment_size", value = "1") })
    private Long id;
    private String lastName;
    private String firstName;
    private String mail;
    private Long tel;
    private Long nbrYearOfExperience;
    private String lastEmployer;
    private String levelOfStudies;
    private String fileUrl;
}
