package kr.ac.kopo.mkj.bookmarket.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class commonException{
    @ExceptionHandler(categoryException.class)
    private ModelAndView handleException(categoryException e, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("errMessage", e.getErrMessage());
        mav.addObject("category", e.getCategory());
        mav.addObject("exception", e.toString());
        mav.addObject("url", request.getRequestURL());
        mav.setViewName("errorCommon");
        return mav;
    }
    @ExceptionHandler(cartException.class)
    private ModelAndView handleCartException(cartException e, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("errMessage", e.getMessage());
        mav.addObject("exception", e.toString());
        mav.addObject("url", request.getRequestURL());
        mav.setViewName("errorCommon");
        return mav;
    }
}