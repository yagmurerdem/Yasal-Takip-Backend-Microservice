package tr.com.cinigaz.service.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import tr.com.cinigaz.dto.AvukatDto;
import tr.com.cinigaz.dto.IhaleDto;
import tr.com.cinigaz.entity.AvukatEntity;
import tr.com.cinigaz.entity.IhaleEntity;
import tr.com.cinigaz.exception.NotFound;
import tr.com.cinigaz.repo.IhaleRepository;
import tr.com.cinigaz.service.YetkiService;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Configuration

public class YetkiServiceImpl implements YetkiService {
    private IhaleRepository ihaleRepository;
    private ModelMapper modelMapper;

    public YetkiServiceImpl(IhaleRepository ihaleRepository, ModelMapper modelMapper) {
        this.ihaleRepository = ihaleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public IhaleDto ihaleEkle(IhaleDto ihaleDto) {
        IhaleEntity ihaleEntity = modelMapper.map(ihaleDto, IhaleEntity.class);
        ihaleEntity.setCreatedBy("yağmur"); // TODO : Yetki yapısında kulanıcı gelecek.
        ihaleEntity.setCreatedAt(new Date());
        ihaleEntity = ihaleRepository.save(ihaleEntity);
        ihaleDto = modelMapper.map(ihaleEntity, IhaleDto.class);
        if (ihaleDto.equals(ihaleDto)) {
            return ihaleDto;
        } else {
            return new IhaleDto();
        }
    }

    @Override
    public IhaleDto ihaleGetirId(Long ihaleId) {
        Optional<IhaleEntity> ihaleentity = ihaleRepository.findById(ihaleId);
        if (ihaleentity.isPresent()) {
            return modelMapper.map(ihaleentity.get(), IhaleDto.class);
        }
        throw new NotFound("İhale Bulunamadı");


    }

    @Override
    public IhaleDto ihaleGuncelle(IhaleDto ihaledto) {
        IhaleEntity gelen = modelMapper.map(ihaledto, IhaleEntity.class);
        gelen.setUpdatedBy("yağmur");
        gelen.setUpdatedAt(new Date());
        gelen = ihaleRepository.save(gelen);
        ihaledto = modelMapper.map(gelen, IhaleDto.class);
        return ihaledto;
    }

    @Override
    public Boolean ihaleSil(IhaleDto ihaleDto) {
        IhaleEntity gelen = modelMapper.map(ihaleDto, IhaleEntity.class);
        try {
            ihaleRepository.delete(gelen);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<IhaleDto> ihaleGetir() {

        List<IhaleEntity> ihaleentities = ihaleRepository.findAll();
        List<IhaleDto> dtos = ihaleentities.stream().map(ihaleentity -> modelMapper.map(ihaleentity, IhaleDto.class)).collect(Collectors.toList());
        return dtos;
    }


}
