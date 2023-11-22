package com.example.happypetsday.mapper;

import com.example.happypetsday.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    //    회원등록(회원가입)
    void insert(UserDto userDto);

    //    회원번호,상태 조회(로그인)
    UserDto selectUserNumberAndStatus(@Param("userId") String userId, @Param("userPassword") String userPassword);

    //     아이디 중복검사
    int countByUserId(@Param("userId") String userId);

    //     마이페이지 비밀번호 검사
    String selectUserPasswordByUserNumber(@Param("userNumber") Long userNumber);

    //     회원 번호로 회원 정보 가져오기(마이페이지용)
    UserDto selectUserInfoByUserNumber(@Param("userNumber") Long userNumber);

    //     마이페이지 회원정보 수정
    void update(UserDto userDto);

    //     아이디 찾기
    String selectUserIdByNameAndPhone(@Param("userName") String userName, @Param("userPhoneNumber") int userPhoneNumber);

//     // 비밀번호 찾기 - 보안 질문과 답변 확인
//     int verifyUserSecurityAnswer(@Param("userId") String userId, @Param("questionNumber") int questionNumber, @Param("answer") String answer);

    // 비밀번호 찾기
    int verifyUserSecurityAnswer(@Param("userId") String userId, @Param("questionNumberInput") int questionNumberInput, @Param("answer") String answer);


     // 비밀번호 찾기
     String getUserPassword(String userId);

     // 회원번호로 이름 가져오기
     String getUserName(Long userNumber);

     // 아이디로 회원 정보 가져오기
    UserDto selectUserInfoByUserId(String userId);

}
