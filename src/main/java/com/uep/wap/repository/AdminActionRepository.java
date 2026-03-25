package com.uep.wap.repository;

import com.uep.wap.model.AdminAction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminActionRepository extends CrudRepository<AdminAction, Integer> {
}
