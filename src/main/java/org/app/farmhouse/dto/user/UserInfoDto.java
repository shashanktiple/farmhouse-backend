package org.app.farmhouse.dto.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.app.farmhouse.constants.Gender;

import java.util.Date;

@Data
@NoArgsConstructor
public class UserInfoDto {
    private String username;
    private String fname;
    private String lname;
    private String email;
    private Gender gender;
    private Date dob;
    private Date created;
    private Date lastSaved;
}
