package com.uep.wap.repository;

import com.uep.wap.model.ModeratorAction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeratorActionRepository extends CrudRepository<ModeratorAction, Long> {
}
