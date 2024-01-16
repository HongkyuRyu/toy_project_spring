package com.project.chat.service;

import org.springframework.http.ResponseEntity;

import com.project.chat.dto.request.auth.CheckCertificationRequestDto;
import com.project.chat.dto.response.auth.CheckCertificationResponseDto;
import com.project.chat.dto.request.auth.EmailCertificationRequestDto;
import com.project.chat.dto.request.auth.IdCheckRequestDto;
import com.project.chat.dto.response.auth.EmailCertificationResponseDto;
import com.project.chat.dto.response.auth.IdCheckResponseDto;

public interface AuthService {

    ResponseEntity<? super IdCheckResponseDto> idCheck(IdCheckRequestDto dto);

    ResponseEntity<? super EmailCertificationResponseDto> emailCertification(EmailCertificationRequestDto dto);

    ResponseEntity<? super CheckCertificationResponseDto> checkCertification(CheckCertificationRequestDto dto);

}
