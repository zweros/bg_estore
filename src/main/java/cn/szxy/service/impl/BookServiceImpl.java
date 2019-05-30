package cn.szxy.service.impl;

import cn.szxy.mapper.BookImageMapper;
import cn.szxy.pojo.BookImage;
import cn.szxy.service.BookService;
import cn.szxy.exception.BookException;
import cn.szxy.mapper.BookMapper;
import cn.szxy.pojo.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * @Auther:wzer
 * @Date:2019/5/29
 * @Description:cn.szxy.cn.szxy.service.iml
 * @Version:1.0
 **/
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private BookImageMapper bookImageMapper;

    @Override
    public void addBook(Books book, MultipartFile img,String imgPath) {
        try {
            //图片原始名
            String imgOriginalFilename = img.getOriginalFilename();
            //图片新的名字
            UUID uuid = UUID.randomUUID();
            String imgPrefix = uuid.toString();
            //获取图片的类型    image/jpeg截取后面的 jpeg
            String imgSuffix = img.getContentType().split("/")[1];
            //完整的图片新的名字
            String imgNewName = uuid+"."+imgSuffix;
            //创建图片对象
            BookImage bookImage =
                    new BookImage(imgOriginalFilename, imgNewName, imgSuffix,book);
            //保存图片到服务器上
            File imgFile = new File(imgPath,imgNewName);
            img.transferTo(imgFile);
            //插入图书、图片信息到数据库保存
            bookMapper.insertBook(book);
            bookImageMapper.insertBookImage(bookImage);
        } catch (Exception e) {
            try {
                throw  new BookException("图书、图片添加失败");
            } catch (BookException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Books findOneBook(long bookId) {
        Books book = bookMapper.findOneBook(bookId);
        return book;
    }

    @Override
    public List<Books> findAllBooks() {
        return bookMapper.findAllBooks();
    }

    @Override
    public List<BookImage> findAllBooksAndImg() {
        return bookImageMapper.selectAllBookImg();
    }


    @Override
    public long findMaxBookId() {
        return bookMapper.selectMaxBookId();
    }

    @Override
    public void delBookById(long bookId) {
        bookMapper.delBookById(bookId);
    }

    @Override
    public Books modifyBook(long bookId) {
        return bookMapper.findOneBook(bookId);
    }

    @Override
    public void updateBook(Books book) {
        bookMapper.updateBookById(book);
    }


}
