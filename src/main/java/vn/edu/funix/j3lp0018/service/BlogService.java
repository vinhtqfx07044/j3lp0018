package vn.edu.funix.j3lp0018.service;

import vn.edu.funix.j3lp0018.dto.PostOverviewDTO;
import vn.edu.funix.j3lp0018.dto.PostHomeDTO;
import vn.edu.funix.j3lp0018.dto.PostDetailDTO;
import vn.edu.funix.j3lp0018.entity.AboutMe;
import vn.edu.funix.j3lp0018.entity.Social;

import java.util.List;
import java.util.Map;

public interface BlogService {
    List<PostHomeDTO> getHomepagePosts();

    PostDetailDTO getPostById(int id);

    Map<String, List<PostOverviewDTO>> getGroupedPosts();

    AboutMe getAboutMe();

    List<Social> getSocials();
}