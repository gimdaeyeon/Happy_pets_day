package com.example.happypetsday.security;


import com.example.happypetsday.dto.UserDto;
import com.example.happypetsday.service.user.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PrincipalDetails implements UserDetails {
    // 로그인한 사용자 정보
    private UserDto user;

    private UserService userService;
    public PrincipalDetails(UserDto user){
        System.out.println("UserDetails(user) 생성: " + user);
        this.user = user;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserDto getUser() {
        return user;
    }


    // 해당 User 의 '권한(들)'을 리턴
    // 현재 로그인한 사용자의 권한정보가 필요할때마다 호출된다. 혹은 필요할때마다 직접 호출해 사용할수도 있다
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        System.out.println("getAuthorities() 호출");

        Collection<GrantedAuthority> collect = new ArrayList<>();

        // DB 에서 user 의 권한(들) 읽어오기
//        List<Authority> list = userService.selectAuthoritiesById(user.getId());
//
//        for(Authority auth : list){
//            collect.add(new GrantedAuthority() {
//                @Override
//                public String getAuthority() {
//                    return auth.getName();
//                }
//
//                // thymeleaf 등에서 확인 활용하기 위하 문자열 (학습목적)
//                @Override
//                public String toString() {
//                    return auth.getName();
//                }
//            });
//        }
        return collect;
    }

    @Override
    public String getPassword() {
        return user.getUserPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    // 계정이 만료되지 않았는지
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 계정이 잠긴건 아닌지?
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 계정 credential 이 만료된건 아닌지?
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 활성화 되었는지?
    @Override
    public boolean isEnabled() {
        return true;
    }
}




