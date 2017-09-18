/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.utp.jobfinder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.utp.jobfinder.model.Cv;
import pl.edu.utp.jobfinder.repository.CvRepository;

/**
 *
 * @author bskibinski
 */
@Service
public class CvService {

    @Autowired
    private CvRepository cvRepository;

    public <S extends Cv> S save(S s) {
        return cvRepository.save(s);
    }

    public Cv findOne(Long id) {
        return cvRepository.findOne(id);
    }

}
