package com.testtecnique.candidature.controllers;


import com.testtecnique.candidature.entities.Candidat;
import com.testtecnique.candidature.services.CandidatService;
import com.testtecnique.candidature.utils.Constante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CandidatController {
    @Autowired
    private CandidatService candidatService;

    @PostMapping("/save/candidature")
    public ResponseEntity<Candidat> saveCandidat(@RequestParam("candidatInformation") String candidatInformation, @RequestParam(value="CV")MultipartFile cv) throws IOException {
                return new ResponseEntity<>(candidatService.saveCandidate(candidatInformation,cv, Constante.UPLOAD_CV_FILE), HttpStatus.OK);
    }

    @GetMapping("/candidates")
    public ResponseEntity<List<Candidat>> findAllCandidates(){
        return new ResponseEntity<>(candidatService.findAllCandidates(),HttpStatus.OK);
    }

    @GetMapping("/cv/{candidatId}")
    public ResponseEntity<String> getCV(@PathVariable Long candidatId) throws IOException {
        return new ResponseEntity<>(candidatService.findCV(candidatId),HttpStatus.OK);
    }
}
