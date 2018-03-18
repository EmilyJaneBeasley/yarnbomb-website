package com.example.yarnbombwebsite.models.data;

import com.example.yarnbombwebsite.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional

public interface UserDao extends CrudRepository <User, Integer>{
}
