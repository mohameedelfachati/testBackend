package com.testtecnique.candidature.services;

import com.testtecnique.candidature.entities.Candidat;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CandidatService {
    Candidat saveCandidate(String candidatInformation, MultipartFile CV, String filePath) throws IOException;
    List<Candidat> findAllCandidates();
    String findCV(Long candidatId) throws IOException;
}
