package com.hama.Hama.controller.admin;

import com.hama.Hama.entities.CategoryEntity;
import com.hama.Hama.entities.ProductEntity;
import com.hama.Hama.service.CategoryService;
import com.hama.Hama.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/quan-tri/san-pham")
public class AdminProductController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;


    @RequestMapping("/danh-sach")
    public String productList(Model model) {
        List<ProductEntity> productEntities = productService.getProducts();
        model.addAttribute("products", productEntities);
        return "admin/products";
    }

    @RequestMapping(value = "/them", method = RequestMethod.GET)
    public String showForm(Model model) {
        List<CategoryEntity> categoryList = categoryService.getCategories();
        model.addAttribute("categoryList", categoryList);
        return "admin/product-add-form";
    }


    @RequestMapping(value = "/them", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String addProduct(Model model, HttpServletRequest request, @RequestParam("thumb") MultipartFile thumb, @RequestParam("multiple_image") MultipartFile[] multipartFiles) {
        String title = request.getParameter("title");
        String price = request.getParameter("price");
        String sale = request.getParameter("sale");
        String desc = request.getParameter("desc");
        String cate_id = request.getParameter("cate_id");
        String status = request.getParameter("status");
        String summary = request.getParameter("summary");
        ProductEntity product = new ProductEntity();
        product.setTitle(title);
        product.setPrice(Float.parseFloat(price));
        product.setSale(Float.parseFloat(sale));
        product.setDescription(desc);
        product.setSummary(summary);
        product.setStatus(status != null);
        product.setCreated(new Date());
        product.setModified(new Date());

        List<String> images = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFiles) {
            images.add(multipartFile.getOriginalFilename());
        }
        if (!images.isEmpty()) {
            String string_images = images.stream().map(n -> String.valueOf(n)).collect(Collectors.joining(";", "", ""));
            product.setImages(string_images);
        }
        if (!thumb.getOriginalFilename().equals("") && thumb.getOriginalFilename() != null) {
            product.setThumb(thumb.getOriginalFilename());
        }
        if (cate_id != null) {
            CategoryEntity category = categoryService.getCategory(Integer.parseInt(cate_id));
            product.setCategory(category);
        }
        Integer id = productService.saveProduct(product);

        if (!images.isEmpty()) {
            for (MultipartFile image : multipartFiles) {
                try {
                    File folderUpload = new File(request.getServletContext().getRealPath("resources/upload/product/" + id));
                    if (!folderUpload.exists()) {
                        folderUpload.mkdirs();
                    }
                    File file = new File(folderUpload, image.getOriginalFilename());
                    image.transferTo(file);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        if (!thumb.getOriginalFilename().equals("") && thumb.getOriginalFilename() != null) {
            try {
                File folderUpload = new File(request.getServletContext().getRealPath("resources/upload/product/" + id));
                if (!folderUpload.exists()) {
                    folderUpload.mkdirs();
                }
                File file = new File(folderUpload, thumb.getOriginalFilename());
                thumb.transferTo(file);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return "redirect:danh-sach";
    }


    @RequestMapping(value = "/chinh-sua", method = RequestMethod.GET)
    public String showFormEdit(Model model, HttpServletRequest request) {
        String id = request.getParameter("id");
        List<CategoryEntity> categoryList = categoryService.getCategories();
        ProductEntity productEntity = productService.getProduct(Integer.parseInt(id));
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("product", productEntity);
        return "admin/product-edit-form";
    }

    @RequestMapping(value = "/chinh-sua", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String updateProduct(Model model, HttpServletRequest request, @RequestParam("thumb") MultipartFile thumb, @RequestParam("multiple_image") MultipartFile[] multipartFiles) {
        String id = request.getParameter("id");
        String old_thumb = request.getParameter("old_thumb");
        String old_images = request.getParameter("old_images");
        String title = request.getParameter("title");
        String price = request.getParameter("price");
        String sale = request.getParameter("sale");
        String desc = request.getParameter("desc");
        String cate_id = request.getParameter("cate_id");
        String status = request.getParameter("status");
        String summary = request.getParameter("summary");
        ProductEntity product = new ProductEntity();
        product.setId(Integer.parseInt(id));
        product.setTitle(title);
        product.setPrice(Float.parseFloat(price));
        product.setSale(Float.parseFloat(sale));
        product.setDescription(desc);
        product.setStatus(status != null);
        product.setModified(new Date());
        product.setSummary(summary);
        List<String> images = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFiles) {
            if (!multipartFile.getOriginalFilename().equals("") && multipartFile.getOriginalFilename() != null) {
                try {
                    File folderUpload = new File(request.getServletContext().getRealPath("resources/upload/product/" + id));
                    if (!folderUpload.exists()) {
                        folderUpload.mkdirs();
                    }
                    File file = new File(folderUpload, multipartFile.getOriginalFilename());
                    multipartFile.transferTo(file);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                images.add(multipartFile.getOriginalFilename());
            }
        }

        if (images.isEmpty()) {
            product.setImages(old_images);
        } else {
            String string_images = images.stream().map(n -> String.valueOf(n)).collect(Collectors.joining(";", "", ""));
            product.setImages(string_images);
        }
        if (!thumb.getOriginalFilename().equals("") && thumb.getOriginalFilename() != null) {
            product.setThumb(thumb.getOriginalFilename());
            try {
                File folderUpload = new File(request.getServletContext().getRealPath("resources/upload/product/" + id));
                if (!folderUpload.exists()) {
                    folderUpload.mkdirs();
                }
                File file = new File(folderUpload, thumb.getOriginalFilename());
                thumb.transferTo(file);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            product.setThumb(old_thumb);
        }
        if (cate_id != null) {
            CategoryEntity category = categoryService.getCategory(Integer.parseInt(cate_id));
            product.setCategory(category);
        }
        productService.saveProduct(product);

        return "redirect:danh-sach";
    }

    @RequestMapping(value = "/xoa", method = RequestMethod.GET)
    public String deleteProduct(HttpServletRequest request) {
        String id = request.getParameter("id");
        productService.deleteProduct(Integer.parseInt(id));
        return "redirect:danh-sach";
    }

}
