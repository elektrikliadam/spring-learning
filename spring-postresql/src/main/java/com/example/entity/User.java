package com.example.entity;

import lombok.*;
//import org.springframework.data.annotation.Id;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

//@Document(indexName = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
@EqualsAndHashCode(of={"id"})
@ToString
public class User {
    @Id
    @SequenceGenerator(name="seq_user",allocationSize = 1)
    @GeneratedValue(generator = "seq_user",strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 100, name = "name")
    private String name;

    @Column(length = 100, name = "surname")
    private String surname;

//    private String address;
//
//    private Date birthdate;
}
