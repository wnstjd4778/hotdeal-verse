package com.example.hotdealverse.post.adapter.out.persistence;


import com.example.hotdealverse.user.adapter.out.persistence.base.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "post")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostJpaEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private String url;

    private long price;

    private long viewCnt;

    @OneToOne
    @JoinColumn(name = "productId")
    private ProductJpaEntity product;


}
