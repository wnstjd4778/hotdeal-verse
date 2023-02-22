package com.example.hotdealverse.post.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToOne(mappedBy = "product")
    private PostJpaEntity post;

    @OneToOne
    @JoinColumn(name = "categoryId")
    private CategoryJpaEntity category;

}
