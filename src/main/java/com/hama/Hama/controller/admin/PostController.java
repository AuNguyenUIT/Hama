package com.hama.Hama.controller.admin;

import com.hama.Hama.entities.PostEntity;
import com.hama.Hama.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/quan-tri/bai-viet")
public class PostController {

    @Autowired
    PostService postService;


    @RequestMapping("/danh-sach")
    public String getListPost(Model model) {
        List<PostEntity> postEntityList = postService.getPosts();
        model.addAttribute("posts", postEntityList);
        return "admin/posts";
    }

    @RequestMapping(value = "/them", method = RequestMethod.GET)
    public String showPostAddForm() {
        return "admin/post-form";
    }

    @RequestMapping(value = "/them", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String addPost(HttpServletRequest request, @RequestParam("thumb") MultipartFile multipartFile) throws IOException, InterruptedException {
        request.setCharacterEncoding("utf-8");
        String title = request.getParameter("title");
        String status = request.getParameter("status");
        String body = request.getParameter("body");

        PostEntity post = new PostEntity();
        post.setStatus(status != null);
        Date date = new Date();
        post.setTitle(title);
        post.setBody(body);
        post.setCreated(date);
        post.setModified(date);
        String fileName = multipartFile.getOriginalFilename();
        if (fileName != null && !fileName.equals("")) {
            try {
                File folderUpload = new File(request.getServletContext().getRealPath("resources/upload/post"));
                if (!folderUpload.exists()) {
                    folderUpload.mkdirs();
                }
                File file = new File(folderUpload, fileName);
                multipartFile.transferTo(file);
                post.setThumb(fileName);
            } catch (Exception e) {
                post.setThumb(null);
                System.out.println(e.getMessage());
            }
        }
        postService.savePost(post);
        return "redirect:danh-sach";
    }

    @RequestMapping(value = "/chinh-sua", method = RequestMethod.GET)
    public String editPost(HttpServletRequest request, Model model) {
        String id = request.getParameter("id");
        PostEntity postEntity = postService.getPost(Integer.parseInt(id));
        model.addAttribute("post", postEntity);
        return "admin/post-form";
    }

    @RequestMapping(value = "/chinh-sua", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String updatePost(HttpServletRequest request, Model model, @RequestParam("thumb") MultipartFile multipartFile) throws ParseException {
        String id = request.getParameter("id");
        String title = request.getParameter("title");
        String body = request.getParameter("body");
        String thumb = request.getParameter("thumb");
        String status = request.getParameter("status");
        PostEntity post = new PostEntity();
        post.setId(Integer.parseInt(id));
        post.setTitle(title);
        post.setModified(new Date());
        post.setBody(body);
        post.setStatus(status != null);
        String fileName = multipartFile.getOriginalFilename();
        if (fileName != null && !fileName.equals("")) {
            try {
                File folderUpload = new File(request.getServletContext().getRealPath("resources/upload/post"));
                if (!folderUpload.exists()) {
                    folderUpload.mkdirs();
                }
                File file = new File(folderUpload, fileName);
                multipartFile.transferTo(file);
                post.setThumb(fileName);
            } catch (Exception e) {
                post.setThumb(null);

                System.out.println(e.getMessage());
            }
        } else {
            post.setThumb(thumb);
        }
        postService.savePost(post);
        return "redirect:danh-sach";
    }

    @RequestMapping(value = "/xoa", method = RequestMethod.GET)
    public String deletePost(HttpServletRequest request, Model model) {
        String id = request.getParameter("id");
        postService.deletePost(Integer.parseInt(id));
        return "redirect:danh-sach";
    }


}