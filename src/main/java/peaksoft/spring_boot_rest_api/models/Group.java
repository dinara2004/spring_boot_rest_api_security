package peaksoft.spring_boot_rest_api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.CascadeType.DETACH;

@Entity
@Table(name = "groups")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "group_gen")
    @SequenceGenerator(name = "group_gen", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "date_of_start")
    private String dateOfStart;

    @Column(name = "date_of_finish")
    private String  dateOfFinish;

    @ManyToMany(cascade = {MERGE, CascadeType.REFRESH})
    @ToString.Exclude
    @JsonIgnore
    private List<Course> courses = new ArrayList<>();

    @OneToMany(mappedBy = "groups",cascade = {MERGE,REFRESH,REMOVE,DETACH})
    @ToString.Exclude
    @JsonIgnore
    private List<Student> students = new ArrayList<>();

    @CreatedDate
    private LocalDate created;

    private Boolean isActive;

    public void setCourse(Course course){
        this.courses.add(course);
    }

    public void setStudent(Student student){
        this.students.add(student);
    }
}
