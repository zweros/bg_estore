package cn.szxy.mapper;

import cn.szxy.pojo.BookImage;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Auther:wzer
 * @Date:2019/5/29
 * @Description:cn.szxy.mapper
 * @Version:1.0
 **/
public class BookImageTest {

    BookImageMapper bookImageMapper;

    @Before
    public void before(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext-dao.xml");
        bookImageMapper  = ac.getBean("bookImageMapper", BookImageMapper.class);
    }


    @Test
    public void selectAllBookImage(){
        List<BookImage> bookImages = bookImageMapper.selectAllBookImg();
        for (BookImage img:bookImages) {
            System.out.println(img);
        }

    }
}
