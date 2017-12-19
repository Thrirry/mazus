package com.mazuz.controller;



import com.mazuz.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    private ProductService productService;

    @Autowired
    public HomeController(ProductService productService) {
        super();
        this.productService = productService;
    }



    @RequestMapping("/")
    public String home(Model model) {
        return "home";
    }

    @RequestMapping("/mazus")
    public String mazus(Model model) {
        return "home";
    }


    @RequestMapping("/customer/signup")
    public String signup(Model model) {
        return "customer/signup";

    }

    @RequestMapping("/*")
    public String fourzerofour(Model model) {
        return "error/error";

    }

    @RequestMapping("/mazus/**")
    public String fourzerofour2(Model model) {
        return "error/error";

    }


    @RequestMapping("/blog")
    public String blog(Model model) {
        return "navbar/blog";

    }

    @RequestMapping("/brans")
    public String brans(Model model) {
        return "navbar/brans";

    }

    @RequestMapping("/pages/documentation")
    public String pagesDoc(Model model) {
        return "pages/documentation";

    }

    @RequestMapping("/pages/about")
    public String pagesAbo(Model model) {
        return "pages/about";

    }

    @RequestMapping("/pages/design")
    public String pagesDes(Model model) {
        return "pages/design";

    }


    @RequestMapping("/documentation")
    public String documentation(Model model) {
        return "pages/documentation";

    }

    @RequestMapping("/contact")
    public String contact(Model model) {
        return "navbar/contact";

    }

    @RequestMapping("/customer/signin")
    public String signin(Model model) {
        return "customer/signin";

    }

    @RequestMapping("/mazus/{url}")
    public String view(@PathVariable(value = "url") String url, Model model) {
        model.addAttribute("product", productService.getByUrl(url));
        return "items/product";
    }

    //product older
    @RequestMapping("/mazus/order/{url}")
    public String views(@PathVariable(value = "url") String url, Model model) {
        model.addAttribute("product", productService.getByUrl(url));
        return "customer/order";
    }

    @RequestMapping("/testsignup")
    public String testsignup(Model model) {
        return "shopcart/test";

    }


}
