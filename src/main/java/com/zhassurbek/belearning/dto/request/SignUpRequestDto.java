package com.zhassurbek.belearning.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignUpRequestDto {

    private String username;
    private String firstName;
    private String lastName;
    private String password;

}
