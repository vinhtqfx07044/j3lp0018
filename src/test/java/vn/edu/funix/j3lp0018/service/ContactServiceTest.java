package vn.edu.funix.j3lp0018.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import vn.edu.funix.j3lp0018.dto.ContactDto;
import vn.edu.funix.j3lp0018.entity.ContactMessage;
import vn.edu.funix.j3lp0018.mapper.ContactMapper;
import vn.edu.funix.j3lp0018.repository.ContactMessageRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

 @ExtendWith(MockitoExtension.class)
class ContactServiceTest {

    @Mock
    private ContactMessageRepository contactMessageRepository;
    @Mock
    private ContactMapper contactMapper;

    @InjectMocks
    private ContactService contactService;

    @Test
    void saveMessage_shouldMapDtoToEntityAndSave() {
        // Arrange
        ContactDto dto = new ContactDto();
        dto.setName("John Doe");
        dto.setEmail("john.doe @example.com");
        dto.setMessage("Test message");

        ContactMessage entity = new ContactMessage();
        entity.setName("John Doe");

        when(contactMapper.toEntity(dto)).thenReturn(entity);
        
        // ArgumentCaptor allows us to capture the object passed to the save method
        ArgumentCaptor<ContactMessage> captor = ArgumentCaptor.forClass(ContactMessage.class);

        // Act
        contactService.saveMessage(dto);

        // Assert & Verify
        verify(contactMessageRepository).save(captor.capture());
        ContactMessage capturedEntity = captor.getValue();
        
        assertEquals("John Doe", capturedEntity.getName());
    }
}
