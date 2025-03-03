package calisma.answerproject.controllers;

import calisma.answerproject.dtos.requests.PostCreateRequest;
import calisma.answerproject.dtos.requests.PostUpdateRequest;
import calisma.answerproject.entities.Post;
import calisma.answerproject.services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {

    PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getAllPosts(@RequestParam Optional<Long> userId){
         return postService.getAllPosts(userId);
    }

    @PostMapping
    public Post createPostUser(@RequestBody PostCreateRequest newPostRequest){
        return postService.createPostUser(newPostRequest);
    }

    @GetMapping("/{postId}")
    public Post getOnePostId(@PathVariable Long postId) {
        return postService.postByOneId(postId);
    }

    @PutMapping("/{postId}")
    public Post updatePostUser(@PathVariable Long postId, @RequestBody PostUpdateRequest updatePostRequest){
        return postService.updatePostUserId(postId, updatePostRequest);
    }
    @DeleteMapping("/{postId}")
    public void deletePost (@PathVariable Long postId){
         postService.deletePostById(postId);
    }
}
