package com.hutech.bai_1.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String ID_Role;
    @Column(nullable = false)
    private String name_Role;

    @OneToMany(mappedBy = "role")
    private List<User> users;
}
