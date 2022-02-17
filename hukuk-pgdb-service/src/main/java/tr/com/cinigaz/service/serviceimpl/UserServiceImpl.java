package tr.com.cinigaz.service.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import tr.com.cinigaz.dto.UserDto;
import tr.com.cinigaz.entity.UserEntity;
import tr.com.cinigaz.repo.UserRepository;
import tr.com.cinigaz.service.UserService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository service;
    private ModelMapper map;

    public UserServiceImpl(UserRepository service, ModelMapper map) {
        this.service = service;
        this.map = map;
    }


    @Override
    public UserDto save(UserDto dto) {
        UserEntity gelen = map.map(dto, UserEntity.class);
        gelen.setCreatedAt(new Date());
        gelen = service.save(gelen);
        map.map(gelen, dto);
        return dto;

    }

    @Override
    public UserDto update(UserDto dto) {
        UserEntity gelen = new UserEntity();
        map.map(dto, gelen);
        gelen.setUpdatedAt(new Date());
        gelen = service.save(gelen);
        map.map(gelen, dto);
        return dto;

    }

    @Override
    public Boolean delete(UserDto dto) {
        UserEntity gelen = map.map(dto, UserEntity.class);
        try {
            service.delete(gelen);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public UserDto getById(Long id) {
        Optional<UserEntity> opt;
        opt = service.findById(id);
        UserDto dto = new UserDto();
        map.map(opt.get(), dto);
        return dto;
    }

    @Override
    public List<UserDto> getAll() {
        List<UserEntity> ent1;
        ent1 = service.findAll();
        List<UserDto> dto = new ArrayList<>();
        for (UserEntity a : ent1) {
            dto.add(map.map(a, UserDto.class));
        }
        return dto;
    }


    @Transactional
    public UserDto findbyemail(String email) {
        Optional<UserEntity> e = Optional.ofNullable(service.findByEmail(email));
       UserDto dto = new UserDto();
        map.map(e.get(), dto);
        return dto;
    }

    @Transactional
    public UserDto findByUsername(String username) {
        UserDto dto = new UserDto();
        Optional<UserEntity> opt = service.findByusername(username);
        if (opt.isPresent())
           map.map(opt.get(), dto);
        return dto;
    }

    public boolean userExist(String username) {
        return service.findByusername(username).isPresent();
    }



}
