package peaksoft.spring_boot_rest_api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_gen")
    @SequenceGenerator(name = "student_gen", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private String email;

    @CreatedDate
    private LocalDate created;


    private Boolean isActive;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonIgnore
    private Group groups;
}