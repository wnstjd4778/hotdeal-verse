package com.example.hotdealverse.post.adapter.out.persistence;

import com.example.hotdealverse.post.domain.CategoryType;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "category")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private CategoryType type;

    @OneToOne(mappedBy = "category")
    private ProductJpaEntity product;
}
