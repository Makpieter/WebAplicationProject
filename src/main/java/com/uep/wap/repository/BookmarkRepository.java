package com.uep.wap.repository;

import com.uep.wap.model.Bookmark;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookmarkRepository extends CrudRepository<Bookmark, Integer> {
}
