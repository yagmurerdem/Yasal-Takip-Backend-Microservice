package tr.com.cinigaz.service.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import tr.com.cinigaz.dto.AvukatDto;
import tr.com.cinigaz.dto.KurumDto;
import tr.com.cinigaz.entity.AvukatEntity;
import tr.com.cinigaz.entity.KurumEntity;
import tr.com.cinigaz.exception.NotFound;
import tr.com.cinigaz.repo.KurumRepository;
import tr.com.cinigaz.service.KurumService;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Configuration

public class KurumServiceImpl implements KurumService {
    private KurumRepository kurumRepository;
    private ModelMapper modelMapper;

    public KurumServiceImpl(KurumRepository kurumRepository, ModelMapper modelMapper) {
        this.kurumRepository = kurumRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public KurumDto kurumEkle(KurumDto kurumDto) {
        KurumEntity kurumEntity = modelMapper.map(kurumDto, KurumEntity.class);
        kurumEntity.setCreatedBy("yağmur"); // TODO : Yetki yapısında kulanıcı gelecek.
        kurumEntity.setCreatedAt(new Date());
        kurumEntity = kurumRepository.save(kurumEntity);
        kurumDto = modelMapper.map(kurumEntity, KurumDto.class);
        if (kurumDto.equals(kurumDto)) {
            return kurumDto;
        } else {
            return new KurumDto();
        }
    }

    @Override
    public KurumDto kurumGetirId(Long kurumId) {
        Optional<KurumEntity> kurumentity = kurumRepository.findById(kurumId);
        if (kurumentity.isPresent()) {
            return modelMapper.map(kurumentity.get(), KurumDto.class);
        }
        throw new NotFound("Kurum Bulunamadı");


    }

    @Override
    public KurumDto kurumGuncelle(KurumDto kurumdto) {
        KurumEntity gelen = modelMapper.map(kurumdto, KurumEntity.class);
        gelen.setUpdatedBy("yağmur");
        gelen.setUpdatedAt(new Date());
        gelen = kurumRepository.save(gelen);
        kurumdto = modelMapper.map(gelen, KurumDto.class);
        return kurumdto;
    }

    @Override
    public Boolean kurumSil(KurumDto kurumDto) {
        KurumEntity gelen = modelMapper.map(kurumDto, KurumEntity.class);
        try {
            kurumRepository.delete(gelen);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<KurumDto> kurumGetir() {

        List<KurumEntity> kurumentities = kurumRepository.findAll();
        List<KurumDto> dtos = kurumentities.stream().map(kurumentity -> modelMapper.map(kurumentity, KurumDto.class)).collect(Collectors.toList());
        return dtos;
    }


}
