package com.example.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.ecommerce.dto.OrderDto;
import com.example.ecommerce.model.Payment;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.model.User;
import com.example.ecommerce.service.OrderService;
import com.example.ecommerce.service.PaymentService;
import com.example.ecommerce.service.ProductService;
import com.example.ecommerce.service.UserService;

import jakarta.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    UserService us;

    @Autowired
    PaymentService ps;

    @Autowired
    OrderService os;

    @Autowired
    ProductService pdservice;

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/order")
    public String order() {
        return "order";
    }

    @GetMapping("/cart")
    public String cart() {
        return "cart";
    }

    @GetMapping("/shop")
    public String shop() {
        return "shop";
    }

    @GetMapping("/checkout")
    public String checkout(Model model, Authentication auth) {
        User user = us.findByAuthentication(auth);
        OrderDto orderDto = new OrderDto();
        List<Payment> payments = ps.findByUserId(user.getId());
        model.addAttribute("order", orderDto);
        model.addAttribute("payments", payments);
        return "checkout";
    }

    @PostMapping("/checkout")
    public String order(@ModelAttribute("order") @Valid OrderDto orderDto, BindingResult result,
    Authentication auth, Model model) {
        System.out.println("me");
        User user = us.findByAuthentication(auth);
        if(result.hasErrors()) {
            List<Payment> payments = ps.findByUserId(user.getId());
            model.addAttribute("order", orderDto);
            model.addAttribute("payments", payments);
            return "checkout";
        }
        os.create(orderDto, user);
        return "index";
    }

    @GetMapping("/profile")
    public String profile(Model model, Authentication auth) {
        User user = us.findByAuthentication(auth);
        model.addAttribute("user", user);
        return "profile";
    }

    @GetMapping("/detail/{idProduct}")
    public String detailProduct(@PathVariable ("idProduct") Long idProduct, Model model) {
        Product productFind = pdservice.findById(idProduct);
        model.addAttribute("product", productFind);
        return "detail";
    }

    @GetMapping("/search")
    public String searchProduct(@RequestParam("keywords") String keywords , Model model) {
    //    List<Product> listProductsSearch =  pdservice.searchProducts(keywords);
    //     model.addAttribute("listProductsSearch", listProductsSearch);
        return "redirect:/shop?keywords=" + keywords;
    }
    
}
