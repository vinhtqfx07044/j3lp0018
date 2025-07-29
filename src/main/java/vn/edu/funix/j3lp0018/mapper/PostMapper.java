package vn.edu.funix.j3lp0018.mapper;

import org.mapstruct.Mapper;
import vn.edu.funix.j3lp0018.dto.PostDto;
import vn.edu.funix.j3lp0018.entity.Post;

import java.util.List;

 @Mapper(componentModel = "spring")
public interface PostMapper {
    PostDto toDto(Post post);
    List<PostDto> toDtoList(List<Post> posts);
}
