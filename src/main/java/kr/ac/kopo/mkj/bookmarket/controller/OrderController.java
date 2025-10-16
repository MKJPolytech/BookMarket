package kr.ac.kopo.mkj.bookmarket.controller;

import kr.ac.kopo.mkj.bookmarket.domain.*;
import kr.ac.kopo.mkj.bookmarket.service.CartService;
import kr.ac.kopo.mkj.bookmarket.service.OrderProService;
import kr.ac.kopo.mkj.bookmarket.service.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/order")
@SessionAttributes({"order", "bookList"})
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private CartService cartService;

    @Autowired
    private OrderProService orderProService;

    //	@Autowired
    //   private BookService bookService;
    @GetMapping("/{cartId}")
    public String requestCartList(@PathVariable String cartId,
                                  @ModelAttribute("order") Order order,
                                  @ModelAttribute("bookList") List<Book> listofBooks) {
        Cart cart = cartService.validateCart(cartId);
        listofBooks.clear();
        order.getOrderItems().clear();
        for (CartItem item : cart.getCartItems().values()) {
            OrderItem oi = new OrderItem();
            Book book = item.getBook();
            listofBooks.add(book);
            oi.setBookId(book.getBookId());
            oi.setQuantity(item.getQuantity());
            oi.setTotalPrice(item.getTotalPrice());
            order.getOrderItems().put(book.getBookId(), oi);
        }
        order.setCustomer(new Customer());
        order.setShipping(new Shipping());
        order.setGrandTotal(cart.getGrandTotal());
        return "redirect:/order/orderCustomerInfo";
    }

    @GetMapping("/orderCustomerInfo")
    public String requestCustomerInfoForm(Model model,
                                          @ModelAttribute("order") Order order) {
        model.addAttribute("customer", order.getCustomer());
        return "orderCustomerInfo";
    }

    @PostMapping("/orderCustomerInfo")
    public String requestCustomerInfo(@ModelAttribute Customer customer,
                                      @ModelAttribute("order") Order order) {
        order.setCustomer(customer);
        return "redirect:/order/orderShippingInfo";
    }

    @GetMapping("/orderShippingInfo")
    public String requestShippingInfoForm(Model model,
                                          @ModelAttribute("order") Order order) {
        model.addAttribute("shipping", order.getShipping());
        return "orderShippingInfo";
    }

    @PostMapping("/orderShippingInfo")
    public String requestShippingInfo(@Valid @ModelAttribute Shipping shipping,
                                      BindingResult bindingResult,
                                      @ModelAttribute("order") Order order) {
        if (bindingResult.hasErrors()) return "orderShippingInfo";
        order.setShipping(shipping);
        return "redirect:/order/orderConfirmation";
    }

    @GetMapping("/orderConfirmation")
    public String requestConfirmation(Model model,
                                      @ModelAttribute("order") Order order,
                                      @ModelAttribute("bookList") List<Book> listofBooks) {
        model.addAttribute("bookList", listofBooks);
        model.addAttribute("order", order);
        return "orderConfirmation";
    }

    @PostMapping("/orderConfirmation")
    public String requestConfirmationFinished(@ModelAttribute("order") Order order,
                                              SessionStatus status) {
        orderProService.save(order);
        return "redirect:/order/orderFinished";
    }

    @GetMapping("/orderFinished")
    public String requestFinished(Model model,
                                  @ModelAttribute("order") Order order,
                                  @ModelAttribute("bookList") List<Book> listofBooks,
                                  SessionStatus status) {
        orderService.saveOrder(order);
        model.addAttribute("order", order);
        // 세션에 보관한 order/bookList만 정리 (전체 세션 무효화 대신)
        status.setComplete();
        listofBooks.clear();
        return "orderFinished";
    }
}
