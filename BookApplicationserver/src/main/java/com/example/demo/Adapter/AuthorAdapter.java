package com.example.demo.Adapter;

import com.example.demo.DTOs.AuthorDTO;
import com.example.demo.Domain.Author;
import org.springframework.stereotype.Service;


public class AuthorAdapter {

    public static  AuthorDTO getAuthorDTOfromAuthor(Author author){
        return new AuthorDTO(author.getName());
    }
    public static Author getAuthorfromAuthorDTO(AuthorDTO authordto){
        return new Author(authordto.getName());
    }
}
