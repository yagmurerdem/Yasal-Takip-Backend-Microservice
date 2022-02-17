package tr.com.cinigaz.service;

import tr.com.cinigaz.dto.MalBilgisiDto;

import java.util.List;

public interface MalBilgisiService {

    MalBilgisiDto save(MalBilgisiDto dto);
    MalBilgisiDto update(MalBilgisiDto dto);
    Boolean delete(MalBilgisiDto dto);
    MalBilgisiDto getById(Long id);
    List<MalBilgisiDto> getAll();
}
