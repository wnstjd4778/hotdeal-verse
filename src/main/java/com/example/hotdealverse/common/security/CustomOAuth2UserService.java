package com.example.hotdealverse.common.security;

import com.example.hotdealverse.common.security.oauth2.OAuth2UserInfo;
import com.example.hotdealverse.common.security.oauth2.OAuth2UserInfoFactory;
import com.example.hotdealverse.user.adapter.out.persistence.UserJpaEntity;
import com.example.hotdealverse.user.adapter.out.persistence.UserRepository;
import com.example.hotdealverse.user.domain.AuthProvider;
import com.example.hotdealverse.user.domain.RoleType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.Date;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;

    public CustomOAuth2UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2UserService<OAuth2UserRequest, OAuth2User> service = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = service.loadUser(userRequest);


        return processOAuth2User(userRequest, oAuth2User);

    }

    private OAuth2User processOAuth2User(OAuth2UserRequest userRequest, OAuth2User oAuth2User) {

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        String userNameAttributeName = userRequest.getClientRegistration()
                .getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();

        OAuth2UserInfo oAuth2UserInfo
                = OAuth2UserInfoFactory.getOAuth2UserInfo(registrationId, oAuth2User.getAttributes());

        Optional<UserJpaEntity> optionalUserJpaEntity
                = this.userRepository.findByProviderKey(oAuth2UserInfo.getId());

        UserJpaEntity userJpaEntity;

        if (optionalUserJpaEntity.isPresent()) {
            userJpaEntity = optionalUserJpaEntity.get();
            updateExistingUser(userJpaEntity);
        } else {
            userJpaEntity = registerNewUser(userRequest, oAuth2UserInfo);
        }
        return new DefaultOAuth2User(Collections.singleton(
                new SimpleGrantedAuthority("USER")),
                oAuth2User.getAttributes(),
                userNameAttributeName
        );
    }

    private UserJpaEntity registerNewUser(OAuth2UserRequest userRequest, OAuth2UserInfo oAuth2UserInfo) {
        UserJpaEntity user = UserJpaEntity.builder()
                .providerType(AuthProvider.valueOf(userRequest.getClientRegistration().getRegistrationId()))
                .providerKey(oAuth2UserInfo.getId())
                .name(oAuth2UserInfo.getName())
                .role(RoleType.USER)
                .accessDate(new Date())
                .build();
        return userRepository.save(user);
    }

    //기존 유저 정보 업데이트
    private UserJpaEntity updateExistingUser(UserJpaEntity existingUser) {
        existingUser.setAccessDate(new Date());
        return userRepository.save(existingUser);
    }
}
