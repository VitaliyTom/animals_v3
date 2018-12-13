package service;

import entity.Animal;
import org.springframework.ui.ModelMap;

public interface AnimalService {


    void create( Animal animal );
    void getIdMax(ModelMap model);
    void delete(Animal animal);
    void getAll(ModelMap model);
//
//    Post getPostById(Long postId);
//
//    void updatePost(Post post);
//
//    void deletePost(Post post);
//
//    List<Post> getAllThePosts();
//
//    void postEdit(PostDTO postDTO);




}
