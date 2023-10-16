package com.example.demo.entity;

import com.example.demo.entity.School;
import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(exclude = {"school", "teacherClasses", "studentSet", "homeroomTeacher"})
@Builder
@Table(name = "classes"
        ,uniqueConstraints = {@UniqueConstraint(columnNames = {"school_id", "class_name"})}
)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TClass{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//    @Transient
//    @Column(name = "school_id")
//    @EqualsAndHashCode.Include
//    private Integer schoolId;

    @Column(name = "class_name")
    @EqualsAndHashCode.Include
    private String className;
    private Integer grade;

    @ManyToOne(cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JoinColumn(name = "school_id")
    private School school;

}
