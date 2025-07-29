package vn.edu.funix.j3lp0018.mapper;

import org.mapstruct.Mapper;
import vn.edu.funix.j3lp0018.dto.AboutMeDto;
import vn.edu.funix.j3lp0018.entity.AboutMe;

 @Mapper(componentModel = "spring")
public interface AboutMeMapper {
    AboutMeDto toDto(AboutMe aboutMe);
}
