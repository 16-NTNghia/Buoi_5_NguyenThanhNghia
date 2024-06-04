package com.hutech.bai_1.RequestEntities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdate {
    private String ID;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String birthDay;
}