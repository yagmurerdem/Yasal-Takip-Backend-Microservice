package tr.com.cinigaz.service;

import tr.com.cinigaz.dto.BorcAndBorcDetayDto;

import java.util.List;

public interface BorcAndBorcDetayService {
    BorcAndBorcDetayDto getBorcAndBorcDetayByBorcId(Long borcId);
    BorcAndBorcDetayDto saveBorcDetay(BorcAndBorcDetayDto dto);
    List<BorcAndBorcDetayDto> getAll();

}
