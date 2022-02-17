package tr.com.cinigaz.service;

import tr.com.cinigaz.dto.MahkemeDto;
import tr.com.cinigaz.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {


    UserDto save(UserDto dto);
    UserDto update(UserDto dto);
    Boolean delete(UserDto dto);
    UserDto getById(Long id);
    List<UserDto> getAll();






}
