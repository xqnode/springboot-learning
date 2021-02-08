package com.xqnode.mongodb.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * user
 * @author xqnode
 */
@Data
@Builder
public class User implements Serializable {

    private String _id;

    private String username;

    private String nickname;

    private String password;

    private static final long serialVersionUID = 1L;
}