package com.hama.Hama.controller.admin;

import com.hama.Hama.entities.CommentEntity;
import com.hama.Hama.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/quan-tri/danh-gia")
public class AdminComentController {

    @Autowired
    CommentService commentService;

    @RequestMapping("/danh-sach")
    public String getAllComments(Model model) {
        List<CommentEntity> comments = commentService.getComments();
        model.addAttribute("comments", comments);
        return "admin/comments";
    }
}
