package com.insurance.business.vo.request;

import com.insurance.utils.page.Page;
import lombok.Data;

@Data
public class GetUserListRequest extends Page {
    private Integer rule;
    private String userName;
}
