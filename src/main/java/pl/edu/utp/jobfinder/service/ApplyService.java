/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.utp.jobfinder.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.utp.jobfinder.model.Apply;
import pl.edu.utp.jobfinder.repository.ApplyRepository;

/**
 *
 * @author bskibinski
 */
@Service
public class ApplyService {

    @Autowired
    private ApplyRepository applyRepository;

    public List<Apply> findByCvEmail(String email) {
        return applyRepository.findByCvEmail(email);
    }

    public List<Apply> findAll() {
        return applyRepository.findAll();
    }

    public <S extends Apply> S save(S s) {
        return applyRepository.save(s);
    }

    public Apply findOne(Long id) {
        return applyRepository.findOne(id);
    }

}
