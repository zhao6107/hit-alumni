package net.i2it.hit.hitef.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 分页功能使用到的类
 * Created by liuming on 2017/5/31.
 */
public class PageVO<T> implements Serializable {

    private int pageSize;//每页记录数
    private int pageIndex;//当前页的索引
    private int totalRecord;//总共多少条记录
    private int totalPage;//总共多少页
    private List<T> pageRecords;//当前页要显示的内容

    public PageVO() {
    }

    public PageVO(int pageSize, int pageIndex, int totalRecord, int totalPage, List<T> pageRecords) {
        this.pageSize = pageSize;
        this.pageIndex = pageIndex;
        this.totalRecord = totalRecord;
        this.totalPage = totalPage;
        this.pageRecords = pageRecords;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getPageRecords() {
        return pageRecords;
    }

    public void setPageRecords(List<T> pageRecords) {
        this.pageRecords = pageRecords;
    }

}
