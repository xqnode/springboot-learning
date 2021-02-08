package com.xqnode.mongodb.dao;

import com.xqnode.mongodb.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author xqnode
 */
@Repository
public interface UserRepository extends MongoRepository<User, Long> {

    /**
     * 根据username查询
     * @param username
     * @return
     */
    User findByUsername(String username);
}
