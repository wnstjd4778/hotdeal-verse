package com.example.hotdealverse.user.application.port.in;

import com.example.hotdealverse.user.domain.User;

public interface GetUserQuery {

    User getUser(Long userId);
}
