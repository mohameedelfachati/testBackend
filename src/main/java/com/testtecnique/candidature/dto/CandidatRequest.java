package com.testtecnique.candidature.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CandidatRequest {
    private String lastName;
    private String firstName;
    private String mail;
    private Long tel;
    private Long nbrYearOfExperience;
    private String lastEmployer;
    private String levelOfStudies;
}
