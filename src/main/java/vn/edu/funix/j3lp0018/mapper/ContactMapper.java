package vn.edu.funix.j3lp0018.mapper;

import org.mapstruct.Mapper;
import vn.edu.funix.j3lp0018.dto.ContactDto;
import vn.edu.funix.j3lp0018.entity.ContactMessage;

 @Mapper(componentModel = "spring")
public interface ContactMapper {
    ContactMessage toEntity(ContactDto contactDto);
}
