package com.example.production_ready_features.services;

import com.example.production_ready_features.dto.PostDTO;

import java.util.List;

public interface PostService {

   List<PostDTO> getAlPosts();

   PostDTO createNewPost(PostDTO inputPost);

   PostDTO getPostById(Long postId);

   PostDTO updatePost(PostDTO inputPost,Long postId);
}
