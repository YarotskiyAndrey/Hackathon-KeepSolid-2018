package service;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import dto.UserDto;
import model.UserEntity;

import javax.inject.Inject;
import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    @Inject
    UserDao userDao;
    @Override
    public List<UserDto> getAllUserList() {
        return userEntityTODto(userDao.getAllUserList());
    }

    private static List<UserDto> userEntityTODto(List<UserEntity> userEntityList) {
        List<UserDto> userDtoList = new ArrayList<>();

        for (UserEntity userEntity : userEntityList) {
            UserDto userDto = new UserDto();

            userDto.setId(userEntity.getId());
            userDto.setName(userEntity.getName());
            userDto.setSurname(userEntity.getSurname());
            userDto.setSkills(userEntity.getSkills());
            userDto.setOnWork(userEntity.getOnWork());
            userDto.setTaskID(userEntity.getTaskID());
            userDto.setTaskStartTime(userEntity.getTaskStartTime());

            userDtoList.add(userDto);
        }

        return userDtoList;
    }
}
