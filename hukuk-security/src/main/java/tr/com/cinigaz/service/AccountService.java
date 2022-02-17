package tr.com.cinigaz.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tr.com.cinigaz.dto.UserDto;
import tr.com.cinigaz.entity.UserEnt;

import java.util.Optional;


@Service
public class AccountService implements UserDetailsService {

    RestTemplate restTemplate;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AccountService(RestTemplate restTemplate, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.restTemplate = restTemplate;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public Boolean getusername(String username) {
        UserDto k = restTemplate.getForObject("http://localhost:9155/kullanici/"+username , UserDto.class);
        return  !(k.getUsername() == null || k.getUsername().isEmpty());
    }

   public Boolean getemail(String email) {
       UserDto k = new UserDto();
       try {
            k = restTemplate.getForObject("http://localhost:9155/kullanici/email/" + email, UserDto.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
       return  !(k.getEmail() == null || k.getEmail().isEmpty());
   }
    public Optional<UserEnt> findbyusername(String username) {
        RestTemplate r = new RestTemplate();
        UserDto dto = r.getForObject("http://localhost:9155/kullanici/"+username , UserDto.class);
        Optional<UserEnt> result = Optional.of(new UserEnt());
        result.get().setAdi(dto.getAdi());
        result.get().setPassword(dto.getPassword());
        result.get().setUsername(dto.getUsername());
        result.get().setId(dto.getId());
        result.get().setRole(dto.getRole());
        if(result.get().getUsername()==null){
            throw new UsernameNotFoundException("Kullanici kayitli değil");
        }
        return result;
    }
    public UserDto setregister(UserDto dto){
        dto.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
        dto.setRole("User");
        return restTemplate.postForObject("http://localhost:9155/kullanici/ekle",dto,UserDto.class);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<UserEnt> dto =findbyusername(s);
        if (dto==null)
            throw new UsernameNotFoundException("kayitli kullanici yok");
        return dto.get();
    }
}
