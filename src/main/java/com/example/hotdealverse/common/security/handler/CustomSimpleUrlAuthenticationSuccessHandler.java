package com.example.hotdealverse.common.security.handler;

import com.example.hotdealverse.common.security.jwt.JwtTokenProvider;
import com.example.hotdealverse.user.domain.Token;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
@Component
public class CustomSimpleUrlAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final JwtTokenProvider jwtTokenProvider;

    @Value("${frontend.redirectUrl}")
    private String targetUrl;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        Token token = jwtTokenProvider.createToken(authentication.getName());
        String targetUrl = determineTargetUrl(request, response, authentication, token);

        Cookie myCookie = new Cookie("token", token.getAccessToken());
        myCookie.setDomain("localhost");
        myCookie.setPath("/");
        myCookie.setMaxAge(3600);
        response.addCookie(myCookie);
        getRedirectStrategy().sendRedirect(request, response, targetUrl);
    }

    protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response, Authentication authentication, Token token) {


        //Todo:리프레쉬토큰 저장
        return UriComponentsBuilder.fromUriString(targetUrl)
                .queryParam("token", token.getAccessToken())
                .build().toUriString();
    }
}
