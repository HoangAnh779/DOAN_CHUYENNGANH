package com.webtourdl.WebTourDuLich.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForgotPasswordDTO {
    private String youremail;

    private String newPassword;
}
