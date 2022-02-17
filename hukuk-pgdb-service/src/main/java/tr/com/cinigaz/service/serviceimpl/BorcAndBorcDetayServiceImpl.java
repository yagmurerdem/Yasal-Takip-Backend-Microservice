package tr.com.cinigaz.service.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import tr.com.cinigaz.dto.BorcAndBorcDetayDto;
import tr.com.cinigaz.entity.BorcDetayEntity;
import tr.com.cinigaz.repo.BorcDetayRepository;
import tr.com.cinigaz.service.BorcAndBorcDetayService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class BorcAndBorcDetayServiceImpl implements BorcAndBorcDetayService {

    private BorcDetayRepository repository;
    private ModelMapper map;

    public BorcAndBorcDetayServiceImpl(BorcDetayRepository repository, ModelMapper map) {
        this.repository = repository;
        this.map = map;
    }

    @Override
    public BorcAndBorcDetayDto getBorcAndBorcDetayByBorcId(Long borcId) {
        Optional<BorcDetayEntity> det = repository.findById(borcId);
        BorcAndBorcDetayDto dto = new BorcAndBorcDetayDto();
        map.map(det.get(),dto);
        return dto;
    }

    @Override
    public BorcAndBorcDetayDto saveBorcDetay(BorcAndBorcDetayDto dto) {
        BorcDetayEntity detay = map.map(dto, BorcDetayEntity.class);
        detay.setCreatedAt(new Date());
        detay.setCreatedBy("hüseyin");
        detay=repository.save(detay);
        map.map(detay,dto);
        return dto;
    }

    @Override
    public List<BorcAndBorcDetayDto> getAll() {
        List<BorcDetayEntity> gelen = repository.findAll();
        List<BorcAndBorcDetayDto> dto = new ArrayList<>();
        for (BorcDetayEntity a : gelen) {
            dto.add(map.map(a, BorcAndBorcDetayDto.class));
        }
        System.out.println(dto);
        return dto;
    }
}