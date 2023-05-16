package com.example.hotdealverse.item.adapter.out.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "item")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private String nickname;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private List<LikeJpaEntity> likeList = new ArrayList<>();

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private List<CommentJpaEntity> commentList = new ArrayList<>();

    private String href;

    private Date createdAt;

    private String imgName;

    @ColumnDefault("0")
    private long viewCnt;

    @ColumnDefault("false")
    private boolean isSend;

    void addLike(LikeJpaEntity likeJpaEntity) {
        this.likeList.add(likeJpaEntity);
    }

    void addComment(CommentJpaEntity commentJpaEntity) {
        this.commentList.add(commentJpaEntity);
    }

    void addViewCnt() {
        this.viewCnt += 1;
    }
}
