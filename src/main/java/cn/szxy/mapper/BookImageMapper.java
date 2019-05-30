package cn.szxy.mapper;

import cn.szxy.pojo.BookImage;
import cn.szxy.pojo.Books;

import java.util.List;

/**
 * @Auther:wzer
 * @Date:2019/5/29
 * @Description:cn.szxy.mapper
 * @Version:1.0
 **/
public interface BookImageMapper {

    /**
     * 添加图书图片信息
     * @param bookImage
     */
    void insertBookImage(BookImage bookImage);

    /**
     * 查找图片信息
     * @return
     */
    BookImage selectBookImgByBookId(long bookId);


    List<BookImage> selectAllBookImg();

}
