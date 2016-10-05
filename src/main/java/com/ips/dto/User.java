package com.ips.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by shenwenbo on 2016/10/4.
 */
@Getter
@Setter
public class User implements Serializable {

    private static final long serialVersionUID = -7091478494529379221L;

    private int id;
    private String username;
    private String password;

}
