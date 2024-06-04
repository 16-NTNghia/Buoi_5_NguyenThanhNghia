package com.hutech.bai_1.RequestEntities;

import com.hutech.bai_1.Entities.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCreate {
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String birthDay;

    private Role role;
}
