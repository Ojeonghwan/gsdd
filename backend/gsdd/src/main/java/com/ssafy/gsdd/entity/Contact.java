package com.ssafy.gsdd.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter @Setter
@ToString(exclude = "user")
@Table(name = "contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contactId")
    private int contactId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String contact;

    @Column(nullable = false)
    private LocalDateTime regDate;

    public Contact(String name, String contact, LocalDateTime regDate, User user) {
        this.name = name;
        this.contact = contact;
        this.regDate = regDate;
        this.addContact(user);
    }

    public void addContact(User user){
        this.user = user;
        user.getContacts().add(this);
    }


}
