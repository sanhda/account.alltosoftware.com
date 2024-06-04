package com.alltosoftware.account.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegistrationDto {
    private Long id;
    private String username;
    private String email;
    private String password;
}
