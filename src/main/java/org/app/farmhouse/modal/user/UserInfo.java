package org.app.farmhouse.modal.user;

import jakarta.persistence.*;
import lombok.Data;
import org.app.farmhouse.constants.Gender;

import java.io.Serializable;
import java.util.Date;

@Entity(name = "userinfo")
@Data
public class UserInfo implements Serializable {

    @Id
    @Column(name = "user_id")
    private String id;

    @Column(length = 50)
    private String fname;

    @Column(length = 50)
    private String lname;

    @Column(length = 50)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Gender gender;

    private Date dob;
    private Date created;
    private Date lastSaved;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

}
