package vn.edu.funix.j3lp0018.service;

import vn.edu.funix.j3lp0018.dto.ContactMessageRequest;

public interface ContactService {
    void saveMessage(ContactMessageRequest request);
}