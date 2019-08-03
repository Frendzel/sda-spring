package pl.sda.springparent.dto;


import lombok.Data;

@Data
public class UserDto {
    String firstName;
    String lastName;
    String email;
    String gender;
    String ipAddress;
}
