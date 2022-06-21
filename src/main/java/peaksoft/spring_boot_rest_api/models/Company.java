package peaksoft.spring_boot_rest_api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "companies")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_gen")
    @SequenceGenerator(name = "company_gen", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    private String companyName;

    private String locatedCountry;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE,
            CascadeType.REFRESH, CascadeType.DETACH },
            mappedBy = "company", orphanRemoval = true)
    @ToString.Exclude
    @JsonIgnore
    private List<Course> courses = new ArrayList<>();

    @CreatedDate
    private LocalDate created;

    private Boolean isActive;

    public void setCourse(Course course) {
        this.courses.add(course);
    }
}
