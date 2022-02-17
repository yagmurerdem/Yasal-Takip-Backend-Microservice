package tr.com.cinigaz.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import tr.com.cinigaz.cfg.JWTTokenHelper;
import tr.com.cinigaz.dto.UserDto;
import tr.com.cinigaz.entity.UserEnt;
import tr.com.cinigaz.exception.CustomParameterConstraintException;
import tr.com.cinigaz.request.LoginRequest;
import tr.com.cinigaz.response.LoginResponse;
import tr.com.cinigaz.service.AccountService;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.List;


@RestController
public class AccountController {
    private final Logger logger = LoggerFactory.getLogger(AccountController.class);
    RestTemplate restTemplate;
    private AccountService service;
    private AuthenticationManager authenticationManager;
    JWTTokenHelper jWTTokenHelper;
    private UserDetailsService userDetailsService;

    private static final String url = "http://localhost:9155/kullanici/tumliste";
    private static final String url2 = "http://localhost:9155/kullanici/ekle";

    public AccountController(RestTemplate restTemplate, AccountService service, AuthenticationManager authenticationManager, JWTTokenHelper jWTTokenHelper, UserDetailsService userDetailsService) {
        this.restTemplate = restTemplate;
        this.service = service;
        this.authenticationManager = authenticationManager;
        this.jWTTokenHelper = jWTTokenHelper;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping(value = "register")
    public ResponseEntity<UserDto> kaydet(@Valid @RequestBody UserDto dto) {
        if (service.getusername(dto.getUsername()))
            throw new CustomParameterConstraintException("Kayitli kullanici var");
        if (service.getemail(dto.getEmail()))
            throw new CustomParameterConstraintException("kayitli e-mail var");

        return ResponseEntity.ok(service.setregister(dto));
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest authenticationRequest) throws InvalidKeySpecException, NoSuchAlgorithmException {

        final Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authenticationRequest.getUsername(), authenticationRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserEnt user=(UserEnt) authentication.getPrincipal();
        String jwtToken=jWTTokenHelper.generateToken(user.getUsername());

        LoginResponse response=new LoginResponse();
        System.out.println(jwtToken);
        response.setToken(jwtToken);


        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "kayit")
    public List<Object> getavukat() {

        Object[] avukats = restTemplate.getForObject(url, Object[].class);

        return Arrays.asList(avukats);
    }


    @GetMapping(value = "email")
    public List<UserDto> getmail(UserDto dto) {
        UserDto emails = restTemplate.getForObject("http://localhost:9155/kullanici/email/" + dto.getEmail(), UserDto.class);
        return Arrays.asList(emails);
    }


}
