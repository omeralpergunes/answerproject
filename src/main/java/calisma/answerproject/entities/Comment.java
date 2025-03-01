package calisma.answerproject.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "\"comments\"")
@Data
public class Comment {

    @Id
    Long id;
    Long postId;
    Long userId;
    @Lob
    @Column(columnDefinition = "text")
    String text;
}
