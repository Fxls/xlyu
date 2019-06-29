package com.itek.spring.springDay04.service;

import com.itek.spring.springDay04.commons.CheckResult;
import com.itek.spring.springDay04.domain.User;

public interface LoginService {

    CheckResult<User> checkUser(User user);
}
