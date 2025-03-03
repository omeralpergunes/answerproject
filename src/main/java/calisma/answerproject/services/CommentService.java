package calisma.answerproject.services;

import calisma.answerproject.dtos.requests.CommentCreateRequest;
import calisma.answerproject.dtos.requests.CommentUpdateRequest;
import calisma.answerproject.entities.Comment;
import calisma.answerproject.entities.User;
import calisma.answerproject.entities.Post;
import calisma.answerproject.repositories.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    CommentRepository commentRepository;
    UserService userService;
    PostService postService;


    public CommentService(CommentRepository commentRepository, UserService userService, PostService postService) {
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.postService = postService;
    }

    public List<Comment> getAllCommentsParam(Optional<Long> userId, Optional<Long> postId) {
        if (userId.isPresent() && postId.isPresent()) {
            return commentRepository.findByUserIdAndPostId(userId.get(), postId.get());
        } else if (userId.isPresent()) {
            return commentRepository.findByUserId(userId.get());
        } else if(postId.isPresent()){
            return commentRepository.findByPostId(postId.get());
        }else
            return commentRepository.findAll();
    }

    public Comment getCommentOneById(Long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    public Comment createOneComment(CommentCreateRequest commentRequest) {
        User user = userService.getUserById(commentRequest.getUserId());
        Post post = postService.postByOneId(commentRequest.getPostId());
        if(user != null && post !=null){
            Comment commentToSave = new Comment();
            commentToSave.setId(commentRequest.getId());
            commentToSave.setPost(post);
            commentToSave.setUser(user);
            commentToSave.setText(commentRequest.getText());
            return commentRepository.save(commentToSave);
        }else
            return null;

    }

    public Comment updateCommentId(Long commentId, CommentUpdateRequest updateRequest) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if(comment.isPresent()){
            Comment commentToUpdate = comment.get();
            commentToUpdate.setText(updateRequest.getText());
            return commentRepository.save(commentToUpdate);
        }
        else
            return null;
    }

    public void deleteOneCommentById(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
