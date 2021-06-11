package com.hama.Hama.controller.admin;

import com.hama.Hama.entities.CategoryEntity;
import com.hama.Hama.service.CategoryService;
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
@RequestMapping("/quan-tri/danh-muc")
public class CategoryController {

    @Autowired
    CategoryService categoryService;


    @RequestMapping("/danh-sach")
    public String getListCategory(Model model) {
        List<CategoryEntity> categoryEntityList = categoryService.getCategories();
        model.addAttribute("categories", categoryEntityList);
        return "admin/categories";
    }

    @RequestMapping(value = "/them", method = RequestMethod.GET)
    public String showCategoryAddForm(Model model) {
        List<CategoryEntity> categoryEntityList = categoryService.getCategories();
        model.addAttribute("categories", categoryEntityList);
        return "admin/category-form";
    }

    @RequestMapping(value = "/them", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String addCategory(HttpServletRequest request, @RequestParam("thumb") MultipartFile multipartFile) throws IOException, InterruptedException {
        request.setCharacterEncoding("utf-8");
        String title = request.getParameter("cate-name");
        String parent = request.getParameter("parent-cate");
        CategoryEntity category = new CategoryEntity();
        if (!parent.equals("0")) {
            CategoryEntity categoryParent = categoryService.getCategory(Integer.parseInt(parent));
            category.setCategory(categoryParent);
        }
        Date date = new Date();
        category.setTitle(title);
        category.setCreated(date);
        category.setModified(date);
        String fileName = multipartFile.getOriginalFilename();
        if (fileName != null && !fileName.equals("")) {
            try {
                File folderUpload = new File(request.getServletContext().getRealPath("resources/upload/category"));
                if (!folderUpload.exists()) {
                    folderUpload.mkdirs();
                }
                File file = new File(folderUpload, fileName);
                multipartFile.transferTo(file);
                category.setThumb(fileName);
            } catch (Exception e) {
                category.setThumb(null);

                System.out.println(e.getMessage());
            }
        }
        categoryService.saveCategory(category);
        return "redirect:danh-sach";
    }

    @RequestMapping(value = "/chinh-sua", method = RequestMethod.GET)
    public String editCategory(HttpServletRequest request, Model model) {
        String id = request.getParameter("id");
        CategoryEntity categoryEntity = categoryService.getCategory(Integer.parseInt(id));
        List<CategoryEntity> categoryEntityList = categoryService.getCategories();
        model.addAttribute("categories", categoryEntityList);
        model.addAttribute("category", categoryEntity);
        return "admin/category-form";
    }

    @RequestMapping(value = "/chinh-sua", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String updateCategory(HttpServletRequest request, Model model, @RequestParam("thumb") MultipartFile multipartFile) throws ParseException {
        String id = request.getParameter("id");
        String title = request.getParameter("cate-name");
        String parent = request.getParameter("parent-cate");
        String thumb = request.getParameter("thumb");
        CategoryEntity category = new CategoryEntity();
        category.setId(Integer.parseInt(id));
        category.setTitle(title);
        category.setModified(new Date());
        if (!parent.equals("0")) {
            CategoryEntity categoryParent = categoryService.getCategory(Integer.parseInt(parent));
            category.setCategory(categoryParent);
        }
        String fileName = multipartFile.getOriginalFilename();
        if (fileName != null && !fileName.equals("")) {
            try {
                File folderUpload = new File(request.getServletContext().getRealPath("resources/upload/category"));
                if (!folderUpload.exists()) {
                    folderUpload.mkdirs();
                }
                File file = new File(folderUpload, fileName);
                multipartFile.transferTo(file);
                category.setThumb(fileName);
            } catch (Exception e) {
                category.setThumb(null);

                System.out.println(e.getMessage());
            }
        } else {
            category.setThumb(thumb);
        }
        categoryService.saveCategory(category);
        return "redirect:danh-sach";
    }

    @RequestMapping(value = "/xoa", method = RequestMethod.GET)
    public String deleteCategory(HttpServletRequest request, Model model) {
        String id = request.getParameter("id");
        categoryService.deleteProduct(Integer.parseInt(id));
        return "redirect:danh-sach";
    }
}
