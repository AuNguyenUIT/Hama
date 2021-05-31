package com.hama.Hama.controller.admin;

import com.hama.Hama.entities.CategoryEntity;
import com.hama.Hama.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Controller
@RequestMapping("/quan-tri/danh-muc")
public class CategoryController {

    @Autowired
    CategoryService categoryService;


    @RequestMapping("/danh-sach")
    public String getListCategory(Model model) {
        List<CategoryEntity> categoryEntityList = categoryService.getAll();
        model.addAttribute("categories", categoryEntityList);
        return "categories";
    }

    @RequestMapping(value = "/them", method = RequestMethod.GET)
    public String showCategoryAddForm(Model model) {
        return "category-add-form";
    }

    @RequestMapping(value = "/them", method = RequestMethod.POST)
    public String addCategory(HttpServletRequest request, Model model) {
        String title = request.getParameter("cate-name");
        CategoryEntity category = new CategoryEntity();
        Date date = new Date();
        category.setTitle(title);
        category.setCreated(date);
        category.setModified(date);
        categoryService.saveCategory(category);
        return "redirect:danh-sach";
    }

    @RequestMapping(value = "/chinh-sua", method = RequestMethod.GET)
    public String editCategory(HttpServletRequest request, Model model) {
        String id = request.getParameter("id");
        System.out.println(categoryService.getCategoryById(Integer.parseInt(id)));
        Optional<CategoryEntity> categoryEntity = categoryService.getCategoryById(Integer.parseInt(id));
        model.addAttribute("category", categoryEntity);
        return "category-add-form";
    }

    @RequestMapping(value = "/chinh-sua", method = RequestMethod.POST)
    public String updateCategory(HttpServletRequest request, Model model) throws ParseException {
        String id = request.getParameter("id");
        String title = request.getParameter("cate-name");
        String created = request.getParameter("created");
        CategoryEntity category = new CategoryEntity();

        DateFormat format = new SimpleDateFormat("yyyy-M-dd H:mm:ss.SSS", Locale.ENGLISH);
        Date dateCreated = format.parse(created);
        category.setId(Integer.parseInt(id));
        category.setTitle(title);
        category.setModified(new Date());
        category.setCreated(dateCreated);
        categoryService.saveCategory(category);
        return "redirect:danh-sach";
    }

    @RequestMapping(value = "/xoa", method = RequestMethod.GET)
    public String deleteCategory(HttpServletRequest request, Model model) {
        String id = request.getParameter("id");
        categoryService.deleteCategoryById(Integer.parseInt(id));
        return "redirect:danh-sach";
    }
}
