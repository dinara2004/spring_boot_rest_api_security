package peaksoft.spring_boot_rest_api.API;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
@PreAuthorize("hasAuthority('ADMIN')")
public class TestAPI {

    @GetMapping("/hello")

    public String helloAdmin(){

        return "I am Max, i am admin";

    }
}
