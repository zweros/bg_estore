package cn.szxy.mapper;

import cn.szxy.pojo.Books;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * @Auther:wzer
 * @Date:2019/5/29
 * @Description:cn.szxy.mapper
 * @Version:1.0
 **/
public interface BookMapper {

    /**
     * 添加图书
     * @param book
     */
    void insertBook(Books book);

    /**
     * 查询图书 ID
     * @param bookId
     * @return
     */
    Books findOneBook(long bookId);

    /**
     * 查询所有图书
     * @return
     */
    List<Books> findAllBooks();

    /**
     * 查询所有图书
     * @return
     */
    Map<Long,Books> findAllBooks2();

    /**
     *  查看当前图书的编号最大值
     */
    long selectMaxBookId();

    /**
     * 删除指定的图书，但不删除该图书的图片
     * @param bookId
     */
    void delBookById(long bookId);

    /**
     * 更新图书信息
     * @param book
     */
    void updateBookById(Books book);
}
