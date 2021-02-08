package com.xqnode.elasticsearch.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * user
 * @author xqnode
 */
@Data
@Builder
@Document(indexName = "mall")
public class User implements Serializable {

    @Id
    private Long id;

    private String username;

    private String nickname;

    private String password;

    private static final long serialVersionUID = 1L;
}