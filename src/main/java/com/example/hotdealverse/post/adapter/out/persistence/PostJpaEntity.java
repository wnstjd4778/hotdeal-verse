package com.example.hotdealverse.post.adapter.out.persistence;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "post")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private Date time;

    private String href;

    private long viewCnt;

}
