package peaksoft.spring_boot_rest_api.dto.CompanyDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyRequest {

    private String companyName;

    private String locatedCountry;
}
