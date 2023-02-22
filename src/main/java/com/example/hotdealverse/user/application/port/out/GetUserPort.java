package com.example.hotdealverse.user.application.port.out;

import com.example.hotdealverse.user.domain.User;

public interface GetUserPort {

    User getUser(long userId);
}
