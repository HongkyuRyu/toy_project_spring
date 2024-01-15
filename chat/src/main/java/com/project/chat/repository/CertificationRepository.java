package com.project.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.chat.entity.Certification;

public interface CertificationRepository extends JpaRepository<Certification, String> {

}
