package tr.com.cinigaz.service;

import tr.com.cinigaz.dto.OdemePlanıEntityDto;

import java.util.List;

public interface OdemePlanService {

    OdemePlanıEntityDto save(OdemePlanıEntityDto dto);
    OdemePlanıEntityDto update(OdemePlanıEntityDto dto);
    Boolean delete(OdemePlanıEntityDto dto);
    OdemePlanıEntityDto getById(Long id);
    List<OdemePlanıEntityDto> getAll();

}
