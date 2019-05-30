package cn.szxy.pojo;

import java.util.Objects;

/**
 * @Auther:wzer
 * @Date:2019/5/29
 * @Description:cn.szxy.pojo
 * @Version:1.0
 * 图书的封面信息
 **/
public class BookImage {
    private long imageId;
    private String newName;
    private String orginName;
    private String imageType;
    // 关联映射
    private Books book;


    public BookImage(String newName, String orginName, String imageType) {
        this.newName = newName;
        this.orginName = orginName;
        this.imageType = imageType;
    }

    public BookImage(String newName, String orginName, String imageType, Books book) {
        this.newName = newName;
        this.orginName = orginName;
        this.imageType = imageType;
        this.book = book;
    }

    public BookImage() {

    }

    public long getImageId() {
        return imageId;
    }

    public void setImageId(long imageId) {
        this.imageId = imageId;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getOrginName() {
        return orginName;
    }

    public void setOrginName(String orginName) {
        this.orginName = orginName;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public Books getBook() {
        return book;
    }

    public void setBook(Books book) {
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookImage bookImage = (BookImage) o;
        return imageId == bookImage.imageId &&
                Objects.equals(newName, bookImage.newName) &&
                Objects.equals(orginName, bookImage.orginName) &&
                Objects.equals(imageType, bookImage.imageType) &&
                Objects.equals(book, bookImage.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imageId, newName, orginName, imageType, book);
    }

    @Override
    public String toString() {
        return "BookImage{" +
                "imageId=" + imageId +
                ", newName='" + newName + '\'' +
                ", orginName='" + orginName + '\'' +
                ", imageType='" + imageType + '\'' +
                ", book=" + book +
                '}';
    }
}
