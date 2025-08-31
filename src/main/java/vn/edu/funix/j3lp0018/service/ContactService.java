package vn.edu.funix.j3lp0018.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.funix.j3lp0018.entity.ContactMessage;
import vn.edu.funix.j3lp0018.repository.ContactMessageRepository;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactMessageRepository contactMessageRepository;

    public void saveMessage(ContactMessage contactMessage) {
        contactMessageRepository.save(contactMessage);
    }
}
