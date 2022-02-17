package tr.com.cinigaz.api;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tr.com.cinigaz.dto.UserDto;
import tr.com.cinigaz.service.serviceimpl.UserServiceImpl;
import tr.com.cinigaz.util.ApiAdresses;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(name= ApiAdresses.UserControllerAdress.ANA,value = ApiAdresses.UserControllerAdress.ANA)
public class UserController {

    private UserServiceImpl service;

    public UserController(UserServiceImpl service) {
        this.service = service;
    }

    @GetMapping(ApiAdresses.UserControllerAdress.TUMLISTE)
    ResponseEntity<List<UserDto>> getall(){
        return ResponseEntity.ok(service.getAll());

    }
    @PostMapping(ApiAdresses.UserControllerAdress.EKLE)
    ResponseEntity<UserDto> ekle(@Valid @RequestBody UserDto dto)  {

             return ResponseEntity.ok(service.save(dto));

    }

    @PutMapping(ApiAdresses.UserControllerAdress.DEGISTIR)
    ResponseEntity<UserDto> guncelle(@Valid @RequestBody UserDto dto){

        return ResponseEntity.ok(service.update(dto));
    }

    @DeleteMapping(ApiAdresses.UserControllerAdress.SIL)
    ResponseEntity<Boolean> delete(@Valid @RequestBody UserDto dto){
        return ResponseEntity.ok(service.delete(dto));
    }

    @GetMapping(ApiAdresses.UserControllerAdress.CEK)
    ResponseEntity<UserDto> getById(@Valid @RequestParam("id") Long id){
        return ResponseEntity.ok(service.getById(id));

    }
   @GetMapping(ApiAdresses.UserControllerAdress.KONTROL+"/{username}")
    ResponseEntity<UserDto> findByname  (@Valid @PathVariable("username") String username)
   {
       UserDto a = service.findByUsername(username);
       return ResponseEntity.ok(a);
    }
    @GetMapping(ApiAdresses.UserControllerAdress.KONTROL2+"/{email}")
    ResponseEntity<UserDto> findByemail (@Valid @PathVariable("email") String email ){


        UserDto dto = service.findbyemail(email);
        if(dto==null)
            return new ResponseEntity<UserDto>(HttpStatus.NOT_FOUND);
           return ResponseEntity.ok(dto);

    }


 }
