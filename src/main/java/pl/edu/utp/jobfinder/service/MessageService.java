/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.utp.jobfinder.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.utp.jobfinder.model.Message;
import pl.edu.utp.jobfinder.repository.MessageRepository;

/**
 *
 * @author bskibinski
 */
@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    public <S extends Message> S save(S s) {
        return messageRepository.save(s);
    }

    public Message findOne(Long id) {
        return messageRepository.findOne(id);
    }

    public List<Message> findByUserEmail(String email) {
        return messageRepository.findByUserEmail(email);
    }

}
