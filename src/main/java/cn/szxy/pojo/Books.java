package cn.szxy.pojo;

/**
 * @Auther:wzer
 * @Date:2019/5/29
 * @Description:cn.szxy.pojo
 * @Version:1.1
 **/
public class Books {
    private long bookId;
    private String name;
    private double price;

    public Books(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Books(long bookId, String name, double price) {
        this.bookId = bookId;
        this.name = name;
        this.price = price;
    }

    /**
     *   提供无参构造函数
     */
    public Books(){

    }

    public Books(double price) {
        this.price = price;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Books{" +
                "bookId=" + bookId +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
