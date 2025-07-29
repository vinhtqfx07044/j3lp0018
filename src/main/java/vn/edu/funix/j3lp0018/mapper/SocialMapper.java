package vn.edu.funix.j3lp0018.mapper;

import org.mapstruct.Mapper;
import vn.edu.funix.j3lp0018.dto.SocialDto;
import vn.edu.funix.j3lp0018.entity.Social;

import java.util.List;

 @Mapper(componentModel = "spring")
public interface SocialMapper {
    List<SocialDto> toDtoList(List<Social> socials);
}
