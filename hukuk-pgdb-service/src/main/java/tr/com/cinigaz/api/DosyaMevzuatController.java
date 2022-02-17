package tr.com.cinigaz.api;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.cinigaz.dto.AvukatDto;
import tr.com.cinigaz.dto.BorcDto;
import tr.com.cinigaz.dto.DosyaMevzuatDto;
import tr.com.cinigaz.service.serviceimpl.DosyaMevzuatServiceImpl;
import tr.com.cinigaz.util.ApiAdresses;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(name= ApiAdresses.DosyaMevzuatControllerAdress.ANA, value = ApiAdresses.DosyaMevzuatControllerAdress.ANA)
public class DosyaMevzuatController {

    private DosyaMevzuatServiceImpl dosyaMevzuatService;

    public  DosyaMevzuatController(DosyaMevzuatServiceImpl dosyaMevzuatService)
    {
        this.dosyaMevzuatService=dosyaMevzuatService;
    }

    @PostMapping(ApiAdresses.DosyaMevzuatControllerAdress.EKLE)
    public ResponseEntity<DosyaMevzuatDto> dosyaMevzuatEkle(@Valid @RequestBody DosyaMevzuatDto dosyaMevzuatDto) {

        return ResponseEntity.ok( dosyaMevzuatService.dosyaMevzuatEkle(dosyaMevzuatDto));
    }

    @GetMapping(ApiAdresses.DosyaMevzuatControllerAdress.TUMLISTE)
    public ResponseEntity<List<DosyaMevzuatDto>> dosyaMevzuatGetir() {
        return ResponseEntity.ok(dosyaMevzuatService.dosyaMevzuatGetir());
    }


    @GetMapping(ApiAdresses.DosyaMevzuatControllerAdress.CEK)
    public ResponseEntity<DosyaMevzuatDto> dosyaMevzuatGetirId( @Valid @PathVariable("id") Long dosyaMevzuatId) {
        return ResponseEntity.ok(dosyaMevzuatService.dosyaMevzuatGetirId(dosyaMevzuatId));
    }

    @PutMapping(ApiAdresses.DosyaMevzuatControllerAdress.DEGISTIR)
    public ResponseEntity<DosyaMevzuatDto>  dosyaMevzuatGuncelle(@Valid  @RequestBody DosyaMevzuatDto dosyaMevzuatDto){
        DosyaMevzuatDto dosyamevzuat = dosyaMevzuatService.dosyaMevzuatGuncelle(dosyaMevzuatDto);
        return ResponseEntity.ok((dosyamevzuat));

    }
    @DeleteMapping(ApiAdresses.DosyaMevzuatControllerAdress.SIL)
    public ResponseEntity<Boolean> dosyaMevzuatSil(@RequestBody @Valid DosyaMevzuatDto dosyaMevzuatDto)
    {
        return ResponseEntity.ok(dosyaMevzuatService.dosyaMevzuatSil(dosyaMevzuatDto));
    }

}
