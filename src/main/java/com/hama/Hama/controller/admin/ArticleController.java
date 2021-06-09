package com.hama.Hama.controller.admin;

import com.hama.Hama.entities.ArticleEntity;
import com.hama.Hama.service.ArticleService;
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
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/quan-tri/bai-viet")
public class ArticleController {

    @Autowired
    ArticleService articleService;


    @RequestMapping("/danh-sach")
    public String getListArticle(Model model) {
        List<ArticleEntity> articleEntityList = articleService.getAll();
        model.addAttribute("articles", articleEntityList);
        return "articles";
    }

    @RequestMapping(value = "/them", method = RequestMethod.GET)
    public String showArticleAddForm(Model model) {
        List<ArticleEntity> articleEntityList = articleService.getAll();
        model.addAttribute("article-form", articleEntityList);
        return "article-form";
    }

    @RequestMapping(value = "/them", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String addArticle(HttpServletRequest request, @RequestParam("thumb") MultipartFile multipartFile) throws IOException, InterruptedException {
        request.setCharacterEncoding("utf-8");
        String title = request.getParameter("article-title");
        String status = request.getParameter("article-status");
        String body=request.getParameter("article-body");
        ArticleEntity article = new ArticleEntity();
        article.setStatus(Integer.parseInt(status));
        Date date = new Date();
        article.setTitle(title);
        article.setBody(body);
        article.setCreated(date);
        article.setModified(date);
        String fileName = multipartFile.getOriginalFilename();

        if (fileName != null && !fileName.equals("")) {
            try {
                File folderUpload = new File(request.getServletContext().getRealPath("resources/upload/article"));
                if (!folderUpload.exists()) {
                    folderUpload.mkdirs();
                }
                File file = new File(folderUpload, fileName);
                multipartFile.transferTo(file);
                article.setThumb(fileName);
            } catch (Exception e) {
                article.setThumb(null);

                System.out.println(e.getMessage());
            }
        }
        
        article = articleService.saveArticle(article);
        return "redirect:danh-sach";
    }

    @RequestMapping(value = "/chinh-sua", method = RequestMethod.GET)
    public String editArticle(HttpServletRequest request, Model model) {
        String id = request.getParameter("id");
        ArticleEntity articleEntity = articleService.getArticleById(Integer.parseInt(id));
        List<ArticleEntity> articleEntityList = articleService.getAll();
        model.addAttribute("article-form", articleEntityList);
        model.addAttribute("articles", articleEntity);
        return "article-form";
    }

    @RequestMapping(value = "/chinh-sua", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String updateArticle(HttpServletRequest request, Model model, @RequestParam("thumb") MultipartFile multipartFile) throws ParseException {
        String id = request.getParameter("id");
        String title = request.getParameter("art-title");
        String body = request.getParameter("art-body");
        String thumb = request.getParameter("thumb");
        String status = request.getParameter("article-status");
        ArticleEntity article = new ArticleEntity();
        article.setId(Integer.parseInt(id));
        article.setTitle(title);
        article.setModified(new Date());
        article.setBody(body);
        article.setStatus(Integer.parseInt(status));
        String fileName = multipartFile.getOriginalFilename();
        if (fileName != null && !fileName.equals("")) {
            try {
                File folderUpload = new File(request.getServletContext().getRealPath("resources/upload/article"));
                if (!folderUpload.exists()) {
                    folderUpload.mkdirs();
                }
                File file = new File(folderUpload, fileName);
                multipartFile.transferTo(file);
                article.setThumb(fileName);
            } catch (Exception e) {
                article.setThumb(null);

                System.out.println(e.getMessage());
            }
        } else {
            article.setThumb(thumb);
        }
        articleService.saveArticle(article);
        return "redirect:danh-sach";
    }

    @RequestMapping(value = "/xoa", method = RequestMethod.GET)
    public String deleteArticle(HttpServletRequest request, Model model) {
        String id = request.getParameter("id");
        articleService.deleteArticleById(Integer.parseInt(id));
        return "redirect:danh-sach";
    }


}