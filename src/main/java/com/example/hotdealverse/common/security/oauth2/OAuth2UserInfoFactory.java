package com.example.hotdealverse.common.security.oauth2;

import com.example.hotdealverse.common.exception.CustomException;
import com.example.hotdealverse.common.exception.ErrorCode;
import com.example.hotdealverse.user.domain.AuthProvider;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class OAuth2UserInfoFactory {

    public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) {
        if(registrationId.equalsIgnoreCase(AuthProvider.kakao.name())) {
            return new KakaoOAuth2UserInfo(attributes);
        } else {
            throw new CustomException(ErrorCode.OAUTH2_AUTHENTICATION_PROCESSING_FAILED);
        }
    }
}
