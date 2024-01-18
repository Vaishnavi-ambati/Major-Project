package com.vishnu.request;

import lombok.Data;

@Data
public class PwdChangeRequest {

    private Integer userid;

    private String email;

    private String pwd;

    private String confirmPwd;
}
