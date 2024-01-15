package com.project.chat.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.chat.common.CertificationNumber;
import com.project.chat.dto.request.auth.EmailCertificationRequestDto;
import com.project.chat.dto.request.auth.IdCheckRequestDto;
import com.project.chat.dto.response.ResponseDto;
import com.project.chat.dto.response.auth.EmailCertificationResponseDto;
import com.project.chat.dto.response.auth.IdCheckResponseDto;
import com.project.chat.entity.Certification;
import com.project.chat.provider.EmailProvider;
import com.project.chat.repository.CertificationRepository;
import com.project.chat.repository.UserRepository;
import com.project.chat.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImplement implements AuthService {

    private final UserRepository userRepository;
    private final CertificationRepository certificationRepository;
    private final EmailProvider emailProvider;

    @Override
    public ResponseEntity<? super IdCheckResponseDto> idCheck(IdCheckRequestDto dto) {
        try {

            String userId = dto.getId();
            boolean isExistId = userRepository.existByUserId(userId);
            // 중복ID가 존재하면, 중복ID에러 반환
            if (isExistId)
                return IdCheckResponseDto.duplicateId();

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.databaseError();
        }

        return IdCheckResponseDto.success();
    }

    @Override
    public ResponseEntity<? super EmailCertificationResponseDto> emailCertification(EmailCertificationRequestDto dto) {
        try {

            String userId = dto.getId();
            String email = dto.getEmail();

            boolean isExistId = userRepository.existByUserId(userId);
            if (isExistId)
                return EmailCertificationResponseDto.duplicateId();
            // 생성된 인증번호
            String certificationNumber = CertificationNumber.getCertificationNumber();

            boolean isSuccessed = emailProvider.sendCertificationMail(email, certificationNumber);
            // 이메일 인증 실패 시
            if (!isSuccessed)
                return EmailCertificationResponseDto.mailSendFailed();

            Certification certificationEntity = new Certification(userId, email, certificationNumber);
            certificationRepository.save(certificationEntity);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.databaseError();
        }

        return EmailCertificationResponseDto.success();
    }

}
