package vn.edu.funix.j3lp0018.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.funix.j3lp0018.dto.ContactDto;
import vn.edu.funix.j3lp0018.entity.ContactMessage;
import vn.edu.funix.j3lp0018.mapper.ContactMapper;
import vn.edu.funix.j3lp0018.repository.ContactMessageRepository;

 @Service @RequiredArgsConstructor
public class ContactService {

    private final ContactMessageRepository contactMessageRepository;
    private final ContactMapper contactMapper;

    public void saveMessage(ContactDto contactDto) {
        ContactMessage contactMessage = contactMapper.toEntity(contactDto);
        contactMessageRepository.save(contactMessage);
    }
}
