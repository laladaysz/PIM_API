package com.easypark.pim.services.authentication;

public interface TokenValidateService {
    String getSubject(String token);
}
