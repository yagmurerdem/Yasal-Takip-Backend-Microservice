package tr.com.cinigaz.service;

import tr.com.cinigaz.dto.HacizDto;

import java.util.List;

public interface HacizService {
    HacizDto hacizEkle(HacizDto hacizDto);
    HacizDto hacizGetirId(Long hacizId);
    HacizDto hacizGuncelle(HacizDto hacizDto);
    Boolean hacizSil(HacizDto hacizDto);
    List<HacizDto> hacizGetir();

}
