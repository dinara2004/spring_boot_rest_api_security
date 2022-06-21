package peaksoft.spring_boot_rest_api.dto.CompanyDto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class CompanyResponse {

    private Long id;

    private String companyName;

    private String locatedCountry;

    private int size;

    private LocalDate created;

    private Boolean isActive;

}
