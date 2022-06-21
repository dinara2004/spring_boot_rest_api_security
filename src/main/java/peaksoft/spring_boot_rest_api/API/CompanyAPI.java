package peaksoft.spring_boot_rest_api.API;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import peaksoft.spring_boot_rest_api.dto.CompanyDto.CompanyRequest;
import peaksoft.spring_boot_rest_api.dto.CompanyDto.CompanyResponse;
import peaksoft.spring_boot_rest_api.service.CompanyService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/company")
public class CompanyAPI {

    private final CompanyService companyService;

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping("/save")
    public CompanyResponse create(@RequestBody CompanyRequest request){

        return companyService.create(request);

    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PutMapping("/update{id}")
    public CompanyResponse update(@PathVariable Long id,
                                  @RequestBody CompanyRequest request) {
        return companyService.update(id, request);

    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'STUDENT', 'TEACHER')")
    @GetMapping("/find/{id}")
    public CompanyResponse findById(@PathVariable Long id){

        return companyService.findById(id);

    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public CompanyResponse delete(@PathVariable Long id){

        return companyService.deleteById(id);

    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'STUDENT', 'TEACHER')")
    @GetMapping
    public List<CompanyResponse> getAllCompanies(){

        return companyService.getAllCompanies();

    }
}
