package calisma.answerproject.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "\"post\"")
@Data
public class Post {

    @Id
    Long id;
    Long postId;
    String title;

    @Lob
    @Column(columnDefinition = "text")
    String text;
}
