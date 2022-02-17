package tr.com.cinigaz.service.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import tr.com.cinigaz.dto.AvukatDto;
import tr.com.cinigaz.entity.AvukatEntity;
import tr.com.cinigaz.repo.AvukatRepository;
import tr.com.cinigaz.service.AvukatService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class AvukatServiceImpl implements AvukatService {

    private AvukatRepository repo;
    private ModelMapper map;

    public AvukatServiceImpl(AvukatRepository repo, ModelMapper map) {
        this.repo = repo;
        this.map = map;
    }


    @Override
    public AvukatDto save(AvukatDto dto) {
        AvukatEntity gelen = map.map(dto,AvukatEntity.class);
        gelen.setCreatedAt(new Date());
        gelen = repo.save(gelen);
        map.map(gelen, dto);
        return dto;
    }

    @Override
    public AvukatDto update(AvukatDto dto) {
        AvukatEntity gelen = map.map(dto, AvukatEntity.class);
        gelen.setUpdatedBy("huseyin");
        gelen.setUpdatedAt(new Date());
        gelen = repo.save(gelen);
        dto = map.map(gelen, AvukatDto.class);
        return dto;
    }

    @Override
    public Boolean delete(Integer sicilNo) {
        AvukatEntity a = repo.getBySicilNo(sicilNo);
        try {
            repo.delete(a);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public AvukatDto getById(Integer id) {

        Optional<AvukatEntity> opt;
        opt = repo.findById(id);

        AvukatDto dto1 = new AvukatDto();
        map.map(opt.get(), dto1);
        return dto1;
    }

    @Override
    public List<AvukatDto> getAll() {
        List<AvukatEntity> entAll = repo.findAll();
        List<AvukatDto> dtoAll = new ArrayList<>();
        for (AvukatEntity a : entAll) {
            dtoAll.add(map.map(a, AvukatDto.class));
        }
        System.out.println(dtoAll);
        return dtoAll;
    }




}