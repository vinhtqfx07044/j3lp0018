package vn.edu.funix.j3lp0018.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.funix.j3lp0018.dto.ContactMessageRequest;
import vn.edu.funix.j3lp0018.entity.ContactMessage;
import vn.edu.funix.j3lp0018.repository.ContactMessageRepository;
import vn.edu.funix.j3lp0018.service.ContactService;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactMessageRepository contactMessageRepository;

    public void saveMessage(ContactMessageRequest request) {
        ContactMessage entity = convertToEntity(request);
        contactMessageRepository.save(entity);
    }

    private ContactMessage convertToEntity(ContactMessageRequest request) {
        ContactMessage entity = new ContactMessage();
        entity.setName(request.getName());
        entity.setEmail(request.getEmail());
        entity.setMessage(request.getMessage());
        return entity;
    }
}
