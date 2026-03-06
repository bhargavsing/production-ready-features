package com.example.production_ready_features.services;

import com.example.production_ready_features.dto.PostDTO;
import com.example.production_ready_features.entities.PostEntity;
import com.example.production_ready_features.exceptions.ResourceNotFoundException;
import com.example.production_ready_features.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceimpl implements PostService {

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<PostDTO> getAlPosts() {
        return postRepository.findAll().stream()
                .map(postEntity -> modelMapper.map(postEntity,PostDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDTO createNewPost(PostDTO inputPost) {
        PostEntity postEntity = modelMapper.map(inputPost,PostEntity.class);
        return modelMapper.map(postRepository.save(postEntity),PostDTO.class);
    }



    @Override
    public PostDTO updatePost(PostDTO inputPost, Long postId) {
        PostEntity olderPost =postRepository.findById(postId)
                .orElseThrow(()->new ResourceNotFoundException("Post not found w/id :"+postId));
        inputPost.setId(postId);

        modelMapper.map(inputPost,olderPost);
        PostEntity savedPostEntity =postRepository.save(olderPost);

        return modelMapper.map(savedPostEntity,PostDTO.class);


    }

    @Override
    public PostDTO getPostById(Long postId) {
       PostEntity postEntity = postRepository
               .findById(postId)
               .orElseThrow(()->new ResourceNotFoundException("Post not found w/id :"+postId));
       return modelMapper.map(postEntity,PostDTO.class);
    }



}
