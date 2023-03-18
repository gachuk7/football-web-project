package com.example.footballwebproject.security;

import com.example.footballwebproject.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;


public class UserDetailsImpl implements UserDetails{

private final User user;
private final String username;

public UserDetailsImpl(User user, String username) {
        this.user = user;
        this.username = username;
        }


    public User getUser() {
        return user;
        }

@Override
public Collection<? extends GrantedAuthority> getAuthorities() {       //관리자인지 확인
//        UserRoleEnum role = user.getRole();
//        String authority = role.getAuthority();

        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("USER");
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(simpleGrantedAuthority);

        return authorities;
        }

@Override
public String getUsername() {
        return this.username;
        }

@Override
public String getPassword() {
        return null;
        }

@Override
public boolean isAccountNonExpired() {
        return false;
        }

@Override
public boolean isAccountNonLocked() {
        return false;
        }

@Override
public boolean isCredentialsNonExpired() {
        return false;
        }

@Override
public boolean isEnabled() {
        return false;
        }
        }