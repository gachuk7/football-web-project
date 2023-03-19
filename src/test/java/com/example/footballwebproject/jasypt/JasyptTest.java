package com.example.footballwebproject.jasypt;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JasyptTest {
    // jasypt 암호화 문자열 테스트
    @Test
    void jasypt_encrypt_decrypt_test(){
        // 암호화 할 평문 입력 - url, db master name, db master password 세 개
        String plainText = "";

        StandardPBEStringEncryptor jasypt = new StandardPBEStringEncryptor();
        // 암호화에 사용될 패스워드 입력 - 해당 문자열이 빌드 시 환경변수로 들어감
        // run - edit configuration : -Djasypt.password='설정한 패스워드'
        jasypt.setPassword("aa");

        // 알고리즘 바탕으로 암호화된 텍스트
        String encryptedText = jasypt.encrypt(plainText);
        String decryptedText = jasypt.decrypt(encryptedText);

        assertThat(decryptedText).isEqualTo(plainText);

        System.out.println(encryptedText);
        System.out.println(decryptedText);
    }
}
