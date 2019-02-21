package com.api.webapp.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
public class Post implements  Comparable<Post>{

    public Post() {
        this.id = UUID.randomUUID();
        this.created = new Date();
    }

    private UUID id;

    @NotNull
    private User user;

    @NotNull
    @Size(max = 140)
    private String msg;

    private Date created;

    @Override
    public int compareTo(Post post) {
        return post.getCreated().compareTo(this.created);
    }
}
