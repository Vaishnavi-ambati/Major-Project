package com.vishnu.service;

import com.vishnu.request.LoginRequest;
import com.vishnu.request.PwdChangeRequest;
import com.vishnu.request.SignUpRequest;
import com.vishnu.response.LoginResponse;

public interface UserService {

    public boolean saveUser(SignUpRequest req);

    public LoginResponse userLogin(LoginRequest req);

    public LoginResponse updatePassword(PwdChangeRequest req);
}
