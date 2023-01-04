package com.example.demo.models.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tbl_registration_detail")
public class DetailRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idRegistrationDetail;

    @ManyToOne
    @JoinColumn(name = "id_course", nullable = false, foreignKey = @ForeignKey(name= "FK_Detail_Registration_Course"))
    private Course course;

    @ManyToOne
    @JoinColumn(name = "id_registration", nullable = false, foreignKey = @ForeignKey(name= "FK_Detail_Registration"))
    private Registration registration;

    @Column(length = 50, nullable = false)
    private String classroom;
}
