package com.example.restfullbadgesystem.domain;

import lombok.Data;
import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

@Entity
@Data
public class Badge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate issueDate;

    private LocalDate expireDate;

    private Boolean isActive = true;

//    public Badge() {
//    }
//    public Badge(Member member, LocalDate expriyDate) {
//        this.isActive = true;
//        this.member = member;
//        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
//        LocalDate now = LocalDate.now(); // Returns instance with current date and time set
//        this.issueDate = LocalDate.parse(formatter.format(now));
//        this.expireDate = expriyDate;
//    }
    @ManyToOne
    private Member member;

}
