/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hama.Hama.controller;

import com.hama.Hama.entities.PostEntity;
import com.hama.Hama.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PostController {

    @Autowired
    PostService postService;


    @RequestMapping("/bai-viet")
    public String getListPost(Model model) {
        String queryString = "From PostEntity WHERE status =1 ORDER BY created DESC";
        List<PostEntity> posts = postService.getPostsByQuery(queryString);
        model.addAttribute("posts", posts);
        return "client/post-archive";
    }


    @RequestMapping("/bai-viet/{post_id}")
    public String postDetail(Model model, @PathVariable String post_id) {
        PostEntity post = postService.getPost(Integer.parseInt(post_id));
        if (post != null) {
            model.addAttribute("post", post);
            String queryString = "From PostEntity WHERE status =1 AND id !=" + post_id + " ORDER BY created DESC";
            List<PostEntity> posts = postService.getPostsByQuery(queryString);
            model.addAttribute("posts", posts);
            return "client/post-single";
        } else {
            return "client/404";
        }
    }
}