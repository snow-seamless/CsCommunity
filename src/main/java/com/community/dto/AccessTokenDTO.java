package com.community.dto;

import lombok.Data;

@Data
public class AccessTokenDTO {
    private String ClientID;
    private String ClientSecret;
    private String Code;
    private String RedirectURI;
    private String State;
}
