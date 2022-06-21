package peaksoft.spring_boot_rest_api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "teachers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_gen")
    @SequenceGenerator(name = "teacher_gen", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    private String firstName;

    private String email;

    private String lastName;

    @OneToOne
    @ToString.Exclude
    @JsonIgnore
    private Course course;

    @CreatedDate
    private LocalDate created;

    private Boolean isActive;

}
