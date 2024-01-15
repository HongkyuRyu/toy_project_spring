package com.project.chat.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity(name = "certification")
@Table(name = "certification")
public class Certification {

    @Id
    private String userId;
    private String email;
    private String certificationNumber;

    @Builder
    public Certification(String userId, String email, String certificationNumber) {
        this.userId = userId;
        this.email = email;
        this.certificationNumber = certificationNumber;
    }
}
