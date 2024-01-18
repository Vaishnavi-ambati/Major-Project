package com.vishnu.response;

import lombok.Data;

@Data
public class LoginResponse {

    private Integer userid;

    private String name;

    private String userType;

    private DashboardResponse dashboardResponse;

    private boolean isValidLogin;

    private boolean pwdChanged;

}
