package com.example.final_titv.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
//@ToString(exclude = "tClassSet")
@ToString(callSuper = true)
@Table(name = "schools")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class School extends BaseEntity{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String address;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Getter
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "school", cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    @ToString.Exclude
    private Set<TClass> tClassSet;
    @Column(name = "cutoff_score")
    private Double cutoffScore; //admission cutoff score
    public void addTClass(TClass tClass){
        try {
            if(tClassSet == null){
                tClassSet = new HashSet<>();
            }
            tClassSet.add(tClass);
        } catch (Exception e) {
            throw new RuntimeException("Add TClass fail!");
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, phoneNumber);
    }

    public void settClassSet(Set<TClass> tClassSet) {
        this.tClassSet = tClassSet;
    }
}
