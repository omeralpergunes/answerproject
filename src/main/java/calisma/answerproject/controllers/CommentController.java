package calisma.answerproject.controllers;

import calisma.answerproject.dtos.requests.CommentCreateRequest;
import calisma.answerproject.dtos.requests.CommentUpdateRequest;
import calisma.answerproject.entities.Comment;
import calisma.answerproject.services.CommentService;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    @GetMapping
    public List<Comment> getAllComment(@RequestParam Optional<Long> userId,
                                       @RequestParam Optional<Long> postId){
        return commentService.getAllCommentsParam(userId, postId);
    }
    @PostMapping
    public Comment createComment (@RequestBody CommentCreateRequest commentRequest ){
        return commentService.createOneComment(commentRequest);
    }
    @GetMapping("/{commentId}")
    public Comment getCommentOneId (@PathVariable Long commentId){
        return commentService.getCommentOneById(commentId);
    }

    @PutMapping("/{commentId}")
        public Comment updateCommentById(@PathVariable Long commentId, @RequestBody CommentUpdateRequest updateRequest){
            return commentService.updateCommentId(commentId, updateRequest);
        }

     @DeleteMapping("/{commentId}")
    public void deleteCommentId (@PathVariable Long commentId){
        commentService.deleteOneCommentById(commentId);
     }
    }
