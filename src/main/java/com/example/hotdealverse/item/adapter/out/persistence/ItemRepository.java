package com.example.hotdealverse.item.adapter.out.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface ItemRepository extends JpaRepository<ItemJpaEntity, Long> {

    Page<ItemJpaEntity> findAllByTitleContaining(String keyword, Pageable pageable);

    Long countAllByTitleContaining(String keyword);

    @Modifying
    @Query("UPDATE ItemJpaEntity i SET i.isSend = true")
    void updateAllItemsToSent();
    @Query("SELECT i FROM ItemJpaEntity i " +
            "WHERE i.createdAt >= :startDate " +
            "ORDER BY CASE WHEN :sortKey = 'viewCnt' THEN i.viewCnt " +
            "ELSE i.likeList.size END DESC, i.createdAt DESC"
    )
    List<ItemJpaEntity> findAllBySortKeyAndStartDate(@Param("sortKey") String sortKey, @Param("startDate") Date startDate, Pageable pageable);
}
