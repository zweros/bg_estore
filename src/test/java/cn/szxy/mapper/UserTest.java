package cn.szxy.mapper;

import cn.szxy.pojo.Books;
import cn.szxy.pojo.Users;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Auther:wzer
 * @Date:2019/5/29
 * @Description:cn.szxy.mapper
 * @Version:1.0
 **/
public class UserTest {

    BookMapper  bookMapper;
    UsersMapper userMapper;

    @Before
    public void before(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext-dao.xml");
        bookMapper = ac.getBean("bookMapper",BookMapper.class);
        userMapper = ac.getBean("usersMapper", UsersMapper.class);
    }

    @Test
    public void insertBook(){
        Books book = new Books(25,"好书zzz", 123);
        bookMapper.insertBook(book);

    }

    /**
     *   org.mybatis.spring.MyBatisSystemException: nested exception is org.apache.ibatis.reflection.ReflectionException: Error instantiating class cn.szxy.pojo.Books with invalid types () or values ().
     *   Cause: java.lang.NoSuchMethodException: cn.szxy.pojo.Books.<init>()
     *
     *   原因：没有为 Books 类提供无参构造函数
     */
    @Test
    public void findOneBook(){
        Books book = bookMapper.findOneBook(10);
        System.out.println(book);
    }

    @Test
    public void findAllBoos(){
        List<Books> books = bookMapper.findAllBooks();
        for (Books book: books) {
            System.out.println(book);
        }
    }

    @Test
    public void findAllBoos2(){
        Map<Long, Books> books = bookMapper.findAllBooks2();
        Set<Map.Entry<Long, Books>> set = books.entrySet();
        Iterator<Map.Entry<Long, Books>> iterator;
        for (iterator = set.iterator();iterator.hasNext();){
            Map.Entry<Long, Books> book = iterator.next();
            System.out.println(book.getKey()+"\t"+book.getValue());
        }
    }

    @Test
    public void selectMaxBookId(){
        long bookId = bookMapper.selectMaxBookId();
        System.out.println(bookId);
    }

    /*
    五月 29, 2019 9:53:30 下午 org.springframework.beans.factory.xml.XmlBeanDefinitionReader loadBeanDefinitions
    信息: Loading XML bean definitions from class path resource [org/springframework/jdbc/support/sql-error-codes.xml]
    五月 29, 2019 9:53:30 下午 org.springframework.jdbc.support.SQLErrorCodesFactory <init>
    信息: SQLErrorCodes loaded: [DB2, Derby, H2, HSQL, Informix, MS-SQL, MySQL, Oracle, PostgreSQL, Sybase, Hana]

    org.springframework.jdbc.BadSqlGrammarException:
            ### Error updating database.  Cause: com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Unknown column 'K1va' in 'field list'
            ### The error may involve cn.szxy.mapper.BookMapper.updateBookById-Inline
    The error occurred while setting parameters
    SQL: update tbl_book set price=111.0,name=K1va where book_id=?
            ### Cause: com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Unknown column 'K1va' in 'field list'
    ; bad SQL grammar []; nested exception is com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Unknown column 'K1va' in 'field list'

    SQL 语句出错
    */
    @Test
    public void updateBook(){
        Books book = new Books(1,"K1va",11);
        bookMapper.updateBookById(book);
    }


    @Test
    public void userTest(){

    }


    @Test
    public void findUser(){
        Users zwz = userMapper.selUserByName("zwz");
        System.out.println(zwz);
    }





}
