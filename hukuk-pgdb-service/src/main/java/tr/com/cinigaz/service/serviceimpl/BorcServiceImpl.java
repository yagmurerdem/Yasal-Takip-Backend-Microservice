package tr.com.cinigaz.service.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import tr.com.cinigaz.dto.BorcDto;
import tr.com.cinigaz.entity.BorcEntity;
import tr.com.cinigaz.repo.BorcRepositoy;
import tr.com.cinigaz.service.BorcService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BorcServiceImpl implements BorcService {
    private BorcRepositoy repos;
    private ModelMapper map;

    public BorcServiceImpl(BorcRepositoy repos, ModelMapper map) {
        this.repos = repos;
        this.map = map;
    }

    @Override
    public BorcDto save(BorcDto dto) {
        BorcEntity gelen = map.map(dto, BorcEntity.class);
        gelen.setCreatedAt(new Date());
        gelen.setCreatedBy("hüseyin");
        gelen = repos.save(gelen);
        map.map(dto, gelen);
        return dto;
    }

    @Override
    public BorcDto update(BorcDto dto) {
        BorcEntity gelen = map.map(dto, BorcEntity.class);
        gelen = repos.save(gelen);
        gelen.setUpdatedAt(new Date());
        gelen.setUpdatedBy("hüseyin");
        dto = map.map(gelen, BorcDto.class);
        return dto;
    }

    @Override
    public Boolean delete(BorcDto dto) {
        BorcEntity gelen = map.map(dto, BorcEntity.class);
        try {
            repos.delete(gelen);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public BorcDto getById(Integer id) {
        Optional<BorcEntity> gelen = repos.findById(id);
        BorcDto dto = new BorcDto();
        map.map(gelen.get(), dto);

        return dto;
    }

    @Override
    public List<BorcDto> getAll() {
        List<BorcEntity> gelen = repos.findAll();
        List<BorcDto> dto = new ArrayList<>();
        for (BorcEntity a : gelen) {
            dto.add(map.map(a, BorcDto.class));
        }
        System.out.println(dto);
        return dto;
    }


}
