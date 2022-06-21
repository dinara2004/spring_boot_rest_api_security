package peaksoft.spring_boot_rest_api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "courses")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_gen")
    @SequenceGenerator(name = "course_gen", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private LocalDate duration;

    @ManyToOne(cascade = {MERGE, DETACH, REFRESH})
    @JsonIgnore
    private Company company;

    @ManyToMany(cascade = {MERGE, CascadeType.REFRESH},mappedBy = "courses")
    @ToString.Exclude
    @JsonIgnore
    private List<Group> groups = new ArrayList<>();

    @OneToOne(mappedBy = "course",
            cascade = {REMOVE},
            orphanRemoval = true)
    @JsonIgnore
    private Teacher teacher;

    @CreatedDate
    private LocalDate created;

    private Boolean isActive;

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}


