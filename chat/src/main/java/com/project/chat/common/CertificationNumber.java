package com.project.chat.common;

public class CertificationNumber {
    // 인증번호 생성
    public static String getCertificationNumber() {
        String certificationNumber = "";

        for (int count = 0; count < 4; count++)
            certificationNumber += (int) (Math.random() * 10);
        return certificationNumber;
    }
}
