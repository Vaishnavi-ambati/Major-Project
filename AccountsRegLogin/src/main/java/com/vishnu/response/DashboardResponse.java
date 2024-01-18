package com.vishnu.response;

import lombok.Data;

@Data
public class DashboardResponse {

    private Long plansCount;

    private Long citizensApprovedCount;
    private Long citizensDeniedCount;

    private Long benefitAmoutTotal;
}
