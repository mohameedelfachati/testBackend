package com.testtecnique.candidature.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testtecnique.candidature.dto.CandidatRequest;
import com.testtecnique.candidature.entities.Candidat;
import com.testtecnique.candidature.repositories.CandidatJPARepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CandidatServiceImpl implements CandidatService{

    @Autowired
    private FileStorageService fileStorageService;
    @Autowired
    private CandidatJPARepository candidatJPARepository;
    @Override
    public Candidat saveCandidate(String candidatInformation, MultipartFile CV, String filePath) throws IOException {

        File uploadPath = new File(filePath);
        ObjectMapper mapper = new ObjectMapper();
        CandidatRequest candidatRequest = mapper.readValue(candidatInformation, CandidatRequest.class);
        if (!uploadPath.exists())
            uploadPath.mkdirs();
        String dirFilePath = filePath + "/" + candidatRequest.getLastName() + "_" +candidatRequest.getFirstName();
        File candidatDir = new File(dirFilePath);
        if(!candidatDir.exists()){
            candidatDir.mkdirs();
            fileStorageService.save(CV, dirFilePath, CV.getOriginalFilename());
        }

        else{
            String newDirFilePath = dirFilePath+"_"+new Date().getTime();
            File newcandidatDir = new File(newDirFilePath);
            newcandidatDir.mkdirs();
            fileStorageService.save(CV, newDirFilePath, CV.getOriginalFilename());

        }


        Candidat candidat = new Candidat();
        candidat.setFileUrl(dirFilePath + "/" + CV.getOriginalFilename());
        candidat.setFirstName(candidatRequest.getFirstName());
        candidat.setLastName(candidatRequest.getLastName());
        candidat.setLastEmployer(candidatRequest.getLastEmployer());
        candidat.setMail(candidatRequest.getMail());
        candidat.setLevelOfStudies(candidatRequest.getLevelOfStudies());
        candidat.setNbrYearOfExperience(candidatRequest.getNbrYearOfExperience());
        candidat.setTel(candidatRequest.getTel());
        try {
          return  candidatJPARepository.save(candidat);
        } catch (Exception e) {
            throw e;
        }


    }

    @Override
    public List<Candidat> findAllCandidates() {
       try{
           return candidatJPARepository.findAll();
       }catch (Exception e) {
           throw e;
       }
    }

    @Override
    public String findCV(Long candidatId) throws IOException {
        Optional<Candidat> candidatOptional = candidatJPARepository.findById(candidatId);
        Candidat candidat = candidatOptional.get();
        String cvPath = candidat.getFileUrl();
        byte[] in=FileUtils.readFileToByteArray(new File(cvPath));
        return Base64.getEncoder().encodeToString(in);
    }
}
