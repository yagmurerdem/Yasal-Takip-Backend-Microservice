package tr.com.cinigaz.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import tr.com.cinigaz.dto.UserDto;

import java.util.Arrays;
import java.util.List;

@RestController
public class ConsumeAvukatWebService {
      private static final String url ="http://localhost:9155/avukat/tumliste";
      private static final String url2 ="http://localhost:9155/avukat/ekle";
      private static final String ulrsil ="http://localhost:9155/avukat/sil";

      RestTemplate restTemplate;

    public ConsumeAvukatWebService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @GetMapping(value = "avukat")
    public List<Object> getavukat(){

        Object[] avukats=restTemplate.getForObject(url,Object[].class);
        return Arrays.asList(avukats);
    }


    @PostMapping(value = "ekle")
    public ResponseEntity<UserDto> kaydet(@RequestBody UserDto dto){
        UserDto res = restTemplate.postForObject(url2,dto,UserDto.class);
        return ResponseEntity.ok(res);

    }
    @DeleteMapping("/delete/{sicilNo}")
    public ResponseEntity<Boolean> delete(@PathVariable("sicilNo")  Integer sicilNo){
        restTemplate.delete(ulrsil+"/"+String.valueOf(sicilNo));
        return ResponseEntity.ok(Boolean.TRUE);
    }




    }


