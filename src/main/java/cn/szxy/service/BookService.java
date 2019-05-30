package cn.szxy.service;

import cn.szxy.pojo.BookImage;
import cn.szxy.pojo.Books;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Auther:wzer
 * @Date:2019/5/29
 * @Description:cn.szxy.cn.szxy.service
 * @Version:1.0
 **/
public interface BookService {

    /**
     * 添加图书、图片信息
     * @param book    图书信息
     * @param img     图书图片信息
     * @param imgPath  图片保存在服务器上的路径
     */
    void addBook(Books book, MultipartFile img,String imgPath);


    /**
     * 查看单个图书信息
     * @param bookId
     * @return
     */
    Books findOneBook(long bookId);

    /**
     * 查找所有图书信息
     * @return
     */
    List<Books> findAllBooks();

    /**
     * 查找所有图书及图片信息
     */
    List<BookImage> findAllBooksAndImg();

    /**
     * 查看最大图书ID
     */
    long findMaxBookId();

    /**
     * 删除指定的图书，但不删除图书的图片
     * @param bookId
     */
    void delBookById(long bookId);

    /**
     * 预更新指定图书信息
     * @param bookId
     */
    Books modifyBook(long bookId);

    /**
     * 更新指定图书信息
     */
    void updateBook(Books book);
}
