package pojo;

import java.util.List;

public class PageBean {


    //分页逻辑
    /*每次能够得到对应页数所需要的pageSize条数据，
      等这些数据都要在jsp中显示出来，
      也就是说每次都要从后台拿那么多数据过来进行显示，
      所以想办法把这些数据封装在一个javabean当中
      每次后台都将查询到的数据放入javabean对象中，
      只需要将该对象存入request作用域，
      然后在jsp页面中从域中获取需要的数据即可。
     一 包含的内容
       1 总内容       lists (JdbcUtil 查询出来)  get set
    *  2 每页条数     pageSize （需要设置的参数 能传入）
    *  3 页数         pageMax （需要总条数 与 每页条数 计算得出）
    *  4 总条数       cont (JdbcUtil 查询出来)  get set
    *  5 当前页       pageNo（能从页面获取 req.）
    *  6 拼接参数      url （能从页面获取）
    *  7 添加到页面的标签 pageView (通过对象添加到jsp)
    * */
    private List<?> lists;
    private int pageSize;
    private int pageMax;
    private int cont;
    private int pageNo;
    private String url;
    private String pageView;

    public PageBean(int pageSize, int cont, int pageNo) {
        this.pageSize = pageSize;
        this.cont = cont;
        this.pageNo = pageNo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    public List<?> getLists() {
        return lists;
    }

    public void setLists(List<?> lists) {
        this.lists = lists;
    }
}
