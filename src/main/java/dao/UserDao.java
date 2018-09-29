package dao;

import model.UserEntity;

import java.util.List;

public interface UserDao {
    List<UserEntity> getAllUserList();
}
