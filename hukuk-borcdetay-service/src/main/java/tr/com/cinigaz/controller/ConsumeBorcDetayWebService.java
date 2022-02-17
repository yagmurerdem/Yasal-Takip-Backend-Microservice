package tr.com.cinigaz.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import tr.com.cinigaz.dto.BorcAndBorcDetayDto;

import java.util.Arrays;
import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:3000/")
public class ConsumeBorcDetayWebService {

    // private static final Logger log = LoggerFactory.getLogger(ConsumeAvukatWebService.class);

    String url = "http://localhost:9155/borcdetay/tumliste";
    String url2="http://localhost:9155/borcdetay/ekle";
    RestTemplate restTemplate;

    public ConsumeBorcDetayWebService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @GetMapping(value = "borcdetay")
    public List<Object> getBorcDetay(){

       // RestTemplate rest = new RestTemplate();
        Object[] borcdetays=restTemplate.getForObject(url,Object[].class);
        return Arrays.asList(borcdetays);
    }




    @PostMapping(value = "borcdetay")
    public ResponseEntity<BorcAndBorcDetayDto> kaydet(@RequestBody BorcAndBorcDetayDto dto){
        ResponseEntity<BorcAndBorcDetayDto> res = restTemplate.postForEntity(url2,dto,BorcAndBorcDetayDto.class);
        BorcAndBorcDetayDto response = res.getBody();
        return ResponseEntity.ok(response);

    }



}


