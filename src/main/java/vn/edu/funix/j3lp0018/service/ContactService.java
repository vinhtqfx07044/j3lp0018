package vn.edu.funix.j3lp0018.service;

import vn.edu.funix.j3lp0018.dto.ContactMessageRequestDTO;

public interface ContactService {
    void saveMessage(ContactMessageRequestDTO request);
}