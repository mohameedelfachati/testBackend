package com.testtecnique.candidature.repositories;

import com.testtecnique.candidature.entities.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatJPARepository extends JpaRepository<Candidat,Long> {

}
