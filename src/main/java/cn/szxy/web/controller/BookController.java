package cn.szxy.web.controller;

import cn.szxy.pojo.BookImage;
import cn.szxy.service.BookService;
import cn.szxy.pojo.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * @Auther:wzer
 * @Date:2019/5/29
 * @Description:cn.szxy.web.controller
 * @Version:1.0
 **/
@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/findMaxBookId")
    public String findMaxBookId(Model model){
        long maxBookId = bookService.findMaxBookId();
        model.addAttribute("maxBookId",maxBookId);
        return "add";
    }

    @RequestMapping("/addBook")
    public ModelAndView addBook(Books book, MultipartFile img, HttpSession session){
        //保存图书的路径
        String imgPath = session.getServletContext().getRealPath("/WEB-INF/images");
        ModelAndView mv = new ModelAndView();
        try{
            //添加图书及图书图片信息
            bookService.addBook(book,img,imgPath);
            mv.addObject("flag","添加图书成功");
            mv.addObject("maxBookId",book.getBookId()+1);
        }catch (Exception e){
            e.printStackTrace();
            mv.addObject("flag","添加图书失败");
            mv.addObject("maxBookId",book.getBookId());
        }
        mv.setViewName("add");
        return mv;
    }

    @RequestMapping("/showAllBook")
    public String showAllBook(Model model){
        List<BookImage> booksAndImgs = bookService.findAllBooksAndImg();
        model.addAttribute("books",booksAndImgs);
        return "list";
    }


    @RequestMapping(value="/delBook/{bookId}",method= RequestMethod.DELETE,produces = "text/html;charset=utf-8")
    @ResponseBody
    public String delBook(@PathVariable long bookId){
        bookService.delBookById(bookId);
        return "删除成功";
    }

    @RequestMapping(value = "/modifyBook/{bookId}")
    public String modifyBook(@PathVariable long bookId,Model model){
        Books book = bookService.modifyBook(bookId);
        model.addAttribute("book",book);
        return "modifyBook";
    }

    @RequestMapping(value = "/updateBook",method = RequestMethod.POST,
            produces = "text/html;charset=utf-8")
    @ResponseBody
    public String updateBook(Books book,Model model){
        bookService.updateBook(book);
        return "更新图书成功";
    }

}
