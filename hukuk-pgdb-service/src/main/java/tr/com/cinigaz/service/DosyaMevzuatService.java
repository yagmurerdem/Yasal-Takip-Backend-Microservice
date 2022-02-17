package tr.com.cinigaz.service;

import tr.com.cinigaz.dto.AvukatDto;
import tr.com.cinigaz.dto.BorcDto;
import tr.com.cinigaz.dto.DosyaMevzuatDto;

import java.util.List;

public interface DosyaMevzuatService {

    DosyaMevzuatDto dosyaMevzuatEkle(DosyaMevzuatDto dosyaMevzuatDto);
    List<DosyaMevzuatDto> dosyaMevzuatGetir();

    DosyaMevzuatDto dosyaMevzuatGuncelle(DosyaMevzuatDto dosyaMevzuatDto);

    Boolean dosyaMevzuatSil(DosyaMevzuatDto dosyaMevzuatDto);
    DosyaMevzuatDto dosyaMevzuatGetirId(Long dosyaMevzuatId);

}
