package tr.com.cinigaz.service;

import tr.com.cinigaz.dto.BorcDto;

import java.util.List;

public interface BorcService {
    BorcDto save(BorcDto dto);
    BorcDto update(BorcDto dto);
    Boolean delete(BorcDto dto);
    BorcDto getById(Integer id);
    List<BorcDto> getAll();
}
