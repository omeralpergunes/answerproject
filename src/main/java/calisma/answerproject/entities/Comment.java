package calisma.answerproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "\"comments\"")
@Data
public class Comment {

    @Id
    Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE) // Bir User sildiğimizde tüm gönderilerini siliyoruz.
    @JsonIgnore //Ignore ettik.
    Post post;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE) // Bir User sildiğimizde tüm gönderilerini siliyoruz.
    @JsonIgnore //Ignore ettik.
    User user;


    @Lob
    @Column(columnDefinition = "text")
    String text;
}
