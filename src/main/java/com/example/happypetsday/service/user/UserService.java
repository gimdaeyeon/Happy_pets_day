package com.example.happypetsday.service.user;

import com.example.happypetsday.dto.UserDto;
import com.example.happypetsday.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    //    회원등록
    public void register(UserDto userDto) {
        if (userDto == null) {
            throw new IllegalArgumentException("회원정보 누락");
        }
        userMapper.insert(userDto);
    }

    /**
     * 회원번호, 상태(일반회원,관리자,탈퇴회원) 조회하기
     *
     * @param userId
     * @param userPassword
     * @throws IllegalArgumentException 존재하지 않는 회원 id, pw로 조회하는 경우
     */
    @Transactional(readOnly = true)
    public UserDto findUserNumberAndStatus(String userId, String userPassword) {
        if (userId == null || userPassword == null) {
            throw new IllegalArgumentException("아이디 또는 패스워드 누락");
        }
        return Optional.ofNullable(userMapper.selectUserNumberAndStatus(userId, userPassword))
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("존재하지 않는 회원입니다.");
                });
    }

    /**
     * 아이디 중복 여부 확인
     *
     * @param userId 아이디
     * @return 중복 여부 (true: 중복되지 않은 아이디, false: 중복된 아이디)
     */
    @Transactional(readOnly = true)
    public boolean isUserIdAvailable(String userId) {
        return userMapper.countByUserId(userId) == 0;
    }

    /**
     * 마이페이지 비밀번호 검사하기
     *
     * @param userNumber
     * @return 로그인한 회원의 비밀번호 리턴
     * @throws IllegalArgumentException 로그인하지 않고 조회하는경우, 존재하지 않는 회원인 경우
     */
    @Transactional(readOnly = true)
    public String findUserPasswordByUserNumber(Long userNumber) {
        if (userNumber == null) {
            throw new IllegalArgumentException("로그인 정보 누락");
        }
        return Optional.ofNullable(userMapper.selectUserPasswordByUserNumber(userNumber))
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("존재하지 않는 회원입니다.");
                });
    }

    @Transactional(readOnly = true)
    public UserDto findUserInfoByUserNumber(Long userNumber) {
        if (userNumber == null) {
            throw new IllegalArgumentException("로그인 정보 누락");
        }
        return Optional.ofNullable(userMapper.selectUserInfoByUserNumber(userNumber))
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("존재하지 않는 회원입니다.");
                });
    }

    //    회원정보 수정
    public void editUserInfo(UserDto userDto) {
        if (userDto == null) {
            throw new IllegalArgumentException("회원정보 누락");
        }
        userMapper.update(userDto);
    }

    //    아이디 찾기
    @Transactional(readOnly = true)
    public String findUserIdByNameAndPhone(String userName, int userPhoneNumber) {
        if (userName == null || userPhoneNumber == 0) {
            throw new IllegalArgumentException("이름 또는 핸드폰 번호 누락");
        }
        String userId = userMapper.selectUserIdByNameAndPhone(userName, userPhoneNumber);
        if (userId == null) {
            throw new IllegalArgumentException("일치하는 아이디가 없습니다.");
        }
        return userId;
    }

    //  비밀번호 찾기
    public String getUserPassword(String userId) {
        return userMapper.getUserPassword(userId);
    }

    //  비밀번호 찾기
    public boolean verifyUserSecurityAnswer(String userId, int questionNumberInput, String answer) {
        int count = userMapper.verifyUserSecurityAnswer(userId, questionNumberInput, answer);
        return count > 0;
    }

    /**
     * 회원번호로 userName 조회하기
     * @param userNumber 회원번호
     * @return userName
     * @throws IllegalArgumentException 존재하지 않는 회원번호인 경우
     */
    @Transactional(readOnly = true)
    public String getUserName(Long userNumber) {
        return userMapper.getUserName(userNumber);
    }

    @Transactional(readOnly = true)
    public UserDto findUserInfoByUserId(String userId){
        if(userId == null){
            throw new IllegalArgumentException("회원id가 입력되지 않았습니다.");
        }
        return userMapper.selectUserInfoByUserId(userId);
    }

}
