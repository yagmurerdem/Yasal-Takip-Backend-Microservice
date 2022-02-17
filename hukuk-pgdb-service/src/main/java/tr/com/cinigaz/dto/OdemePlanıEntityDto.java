package tr.com.cinigaz.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OdemePlanıEntityDto {


    private Long odemePlaniId;
    private double tutar;
    private double faiz;
    private int taksitSecenek;
    private double sonTutar;

}
