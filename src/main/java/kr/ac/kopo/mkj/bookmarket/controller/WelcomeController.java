package kr.ac.kopo.mkj.bookmarket.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String welcomeMethod() {
        String welcomeHtml = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Welcome BookMarket</title>\n" +
                "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\"\n" +
                "          rel=\"stylesheet\" integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\"\n" +
                "          crossorigin=\"anonymous\">\n" +
                "</head>\n" +
                "<body>\n" +
                "<main>\n" +
                "    <div class=\"container py-4\">\n" +
                "        <header class=\"pb-3 mb-4 border-bottom\">\n" +
                "            <a href=\"/\" class=\"d-flex align-items-center text-body-emphasis text-decoration-none\">\n" +
                "                <svg version=\"1.0\" id=\"Layer_1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"\n" +
                "                     width=\"32px\" height=\"32px\" viewBox=\"0 0 64 64\" enable-background=\"new 0 0 64 64\" xml:space=\"preserve\">\n" +
                "<g>\n" +
                "\t<path fill=\"#231F20\" d=\"M1.59,0.805C0.59,1.562,0,2.746,0,4v48c0,1.785,1.184,3.355,2.902,3.848L28,64V8L5.098,0.152\n" +
                "\t\tC3.895-0.188,2.594,0.051,1.59,0.805z\"/>\n" +
                "    <path fill=\"#231F20\" d=\"M62.41,0.805c-1.004-0.754-2.309-0.992-3.508-0.652L36,8v56l25.098-8.152C62.816,55.355,64,53.785,64,52V4\n" +
                "\t\tC64,2.746,63.41,1.562,62.41,0.805z\"/>\n" +
                "</g>\n" +
                "</svg>\n" +
                "                <title>Bootstrap</title><path fill-rule=\"evenodd\" clip-rule=\"evenodd\" d=\"M24.509 0c-6.733 0-11.715 5.893-11.492 12.284.214 6.14-.064 14.092-2.066 20.577C8.943 39.365 5.547 43.485 0 44.014v5.972c5.547.529 8.943 4.649 10.951 11.153 2.002 6.485 2.28 14.437 2.066 20.577C12.794 88.106 17.776 94 24.51 94H93.5c6.733 0 11.714-5.893 11.491-12.284-.214-6.14.064-14.092 2.066-20.577 2.009-6.504 5.396-10.624 10.943-11.153v-5.972c-5.547-.529-8.934-4.649-10.943-11.153-2.002-6.484-2.28-14.437-2.066-20.577C105.214 5.894 100.233 0 93.5 0H24.508zM80 57.863C80 66.663 73.436 72 62.543 72H44a2 2 0 01-2-2V24a2 2 0 012-2h18.437c9.083 0 15.044 4.92 15.044 12.474 0 5.302-4.01 10.049-9.119 10.88v.277C75.317 46.394 80 51.21 80 57.863zM60.521 28.34H49.948v14.934h8.905c6.884 0 10.68-2.772 10.68-7.727 0-4.643-3.264-7.207-9.012-7.207zM49.948 49.2v16.458H60.91c7.167 0 10.964-2.876 10.964-8.281 0-5.406-3.903-8.178-11.425-8.178H49.948z\" fill=\"currentColor\"></path></svg>\n" +
                "                <span class=\"fs-4\">&nbsp;&nbsp; BookMarket</span>\n" +
                "            </a>\n" +
                "        </header>\n" +
                "\n" +
                "        <div class=\"p-5 mb-4 bg-body-tertiary rounded-3\">\n" +
                "            <div class=\"container-fluid py-5\">\n" +
                "                <h1 class=\"display-5 fw-bold\">도서 쇼핑몰에 오신 것을 환영합니다.</h1>\n" +
                "                <p class=\"col-md-8 fs-4\">BookMarket</p>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "\n" +
                "        <div class=\"row align-items-md-stretch text-center\">\n" +
                "            <div class=\"col-md-12\">\n" +
                "                <div class=\"h-100 p-5\">\n" +
                "                    <h2>Welcome to Web Market</h2>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "\n" +
                "        </div>\n" +
                "\n" +
                "        <footer class=\"pt-3 mt-4 text-body-secondary border-top\">\n" +
                "            <span class=\"text-body-secondary\">&copy; 2025 BookMarket</span>\n" +
                "        </footer>\n" +
                "    </div>\n" +
                "</main>\n" +
                "</body>\n" +
                "</html>";

        return welcomeHtml;
    }
}
