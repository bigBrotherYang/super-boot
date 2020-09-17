package com.xtkj.service.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordDamo {
    public static void main(String[] args) {
        BCryptPasswordEncoder b = new BCryptPasswordEncoder();

        String hello = b.encode("hello");
        System.out.println(hello);

        System.out.println(b.matches("hello", "$2a$10$jVtK05oT7tcmMphePGfdsuI1qGeMwOkgs52aGJas.FkBXAulD6G6C"));



    }
}
