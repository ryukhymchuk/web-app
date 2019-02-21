package com.api.webapp.controller;

import com.api.webapp.entity.Post;
import com.api.webapp.service.PostService;
import com.api.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@RestController
public class WebApiController {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @GetMapping(path = "/follow",  produces = "application/json")
    public ResponseEntity<String> follow(@RequestParam String user1,
                                         @RequestParam String user2) {
         userService.follow(user1,user2);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/getUserPosts",  produces = "application/json")
    public ResponseEntity<List<Post>> getUserPosts(@RequestParam String user) {
        List<Post> posts = postService.getUserPosts(user);
        Collections.sort(posts);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }


    @GetMapping(path = "/getFollowersPosts",  produces = "application/json")
    public ResponseEntity<List<Post>> getFollowersPosts(@RequestParam String user) {
        List<Post> posts = new LinkedList<>();
        this.userService.findUser(user).getFollowingUsr().forEach(s -> posts.addAll(postService.getUserPosts(s.getLogin())));
        Collections.sort(posts);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }


    @PostMapping(path = "/post", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> post(@Valid @RequestBody Post post) {
        this.postService.postMessage(post);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
