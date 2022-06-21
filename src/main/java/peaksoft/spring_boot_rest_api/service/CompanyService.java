package peaksoft.spring_boot_rest_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import peaksoft.spring_boot_rest_api.dto.CompanyDto.CompanyRequest;
import peaksoft.spring_boot_rest_api.dto.CompanyDto.CompanyResponse;
import peaksoft.spring_boot_rest_api.models.Company;
import peaksoft.spring_boot_rest_api.mapper.CompanyMapper.CompanyEditMapper;
import peaksoft.spring_boot_rest_api.mapper.CompanyMapper.CompanyViewMapper;
import peaksoft.spring_boot_rest_api.repository.CompanyRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository repository;

    private final CompanyEditMapper editMapper;

    private final CompanyViewMapper viewMapper;


    public CompanyResponse create(CompanyRequest companyRequest){

        Company company = editMapper.create(companyRequest);

        repository.save(company);

        return viewMapper.viewCompany(company);

    }

    public CompanyResponse update(Long id,
                                  CompanyRequest companyRequest){

        Company company = getCompanyById(id);

        editMapper.update(company, companyRequest);

        return viewMapper.viewCompany(repository.save(company));

    }

    public CompanyResponse findById(Long id){

        Company company = getCompanyById(id);

        return viewMapper.viewCompany(company);

    }

    private Company getCompanyById(Long companyId) {

        return repository.findById(companyId).

                orElseThrow(() -> new NotFoundException(

                        "Company with id = " + companyId + " not found!"

                ));
    }

    public CompanyResponse deleteById(Long id){

        Company company = repository.getById(id);

        repository.delete(company);

        return viewMapper.viewCompany(company);

    }

    public List<CompanyResponse> getAllCompanies(){

        return viewMapper.view(repository.findAll());

    }
}
