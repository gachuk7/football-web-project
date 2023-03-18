package com.example.footballwebproject.user;

import com.example.footballwebproject.entity.User;
import com.example.footballwebproject.exception.ApiException;
import com.example.footballwebproject.exception.ExceptionEnum;
import com.example.footballwebproject.jwt.JwtUtil;
import com.example.footballwebproject.user.dto.LoginRequestDto;
import com.example.footballwebproject.user.dto.SignupRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;
@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private static final String ADMIN_TOKEN = "AAABnvxRVklrnYxKZ0aHgTBcXukeZygoC";

    @Transactional
    public void signup(SignupRequestDto signupRequestDto) {
        String username = signupRequestDto.getUsername();
        String password = signupRequestDto.getPassword();
        // String email = signupRequestDto.getEmail();

        // 회원 중복 확인
        Optional<User> found = userRepository.findByUsername(username);    //
        if (found.isPresent()) {              //isPresent는 Optional객의 값이 NULL인지 아닌지 판단해준다.
            throw new ApiException(ExceptionEnum.DUPLICATED_USERNAME);
        }

        // User user = userRepository.findByUsername(username)   //위에 Optional<User>과 같은 코드
        //           .orElseThrow(() -> new IllegalArgumentException("중복된 사용자가 존재합니다."));

        User user = new User(username, password);
        userRepository.save(user);

    }

    @Transactional(readOnly = true)
    public void login(LoginRequestDto loginRequestDto, HttpServletResponse response) {
        String username = loginRequestDto.getUsername();
        String password = loginRequestDto.getPassword();
        log.info("username={}",username);                        /////////////

        // 사용자 확인
        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new ApiException(ExceptionEnum.USER_NOT_FOUND)
        );

        // 비밀번호 확인
        if(!user.getPassword().equals(password)){
           throw new ApiException(ExceptionEnum.NOT_SAME_PASSWORD);
        }

        response.addHeader(JwtUtil.AUTHORIZATION_HEADER, jwtUtil.createToken(user.getUsername()));
    }
}

