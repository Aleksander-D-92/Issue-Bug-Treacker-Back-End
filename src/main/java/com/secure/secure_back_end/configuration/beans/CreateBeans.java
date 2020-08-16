package com.secure.secure_back_end.configuration.beans;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class CreateBeans
{
    @Bean
    public BCryptPasswordEncoder getBCryptPasswordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ModelMapper getModelMapper()
    {
        return new ModelMapper();
    }
}
