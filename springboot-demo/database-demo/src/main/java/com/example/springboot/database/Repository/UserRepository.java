package com.example.springboot.database.Repository;

import com.example.springboot.database.module.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 类职责：<br/>
 *
 * <p>Title: UserRepository.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 </p>
 * <p>Company: </p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年11月16日 下午下午 6:02
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}