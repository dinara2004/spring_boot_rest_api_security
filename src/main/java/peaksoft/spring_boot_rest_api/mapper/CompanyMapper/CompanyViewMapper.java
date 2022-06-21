package peaksoft.spring_boot_rest_api.mapper.CompanyMapper;

import org.springframework.stereotype.Component;
import peaksoft.spring_boot_rest_api.dto.CompanyDto.CompanyResponse;
import peaksoft.spring_boot_rest_api.models.Company;

import java.util.ArrayList;
import java.util.List;

@Component
public class CompanyViewMapper {

    public CompanyResponse viewCompany(Company company) {

        if (company == null) {

            return null;
        }

        return CompanyResponse.builder()

                .id(company.getId())

                .companyName(company.getCompanyName())

                .locatedCountry(company.getLocatedCountry())

                .isActive(company.getIsActive())

                .created(company.getCreated())

                .size(company.getCourses().size())

                .build();
    }

    public List<CompanyResponse> view(List<Company> companies){

        List<CompanyResponse> responses = new ArrayList<>();

        for (Company company: companies) {

            responses.add(viewCompany(company));

        }

        return responses;

    }
}
