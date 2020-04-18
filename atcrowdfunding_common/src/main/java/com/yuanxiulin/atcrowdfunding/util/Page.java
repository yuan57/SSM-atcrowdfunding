package com.yuanxiulin.atcrowdfunding.util;

import java.util.List;

public class Page {

    private Integer pageNo;
    private Integer pageSize;
    private List data;
    private Integer totalSize;
    private Integer totalNo;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public Integer getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Integer totalSize) {
        this.totalSize = totalSize;
        this.totalNo = (this.totalSize%this.pageSize)==0?(this.totalSize/this.pageSize):(this.totalSize/this.pageSize+1);
    }

    public Integer getTotalNo() {
        return totalNo;
    }

    private void setTotalNo(Integer totalNo) {
        this.totalNo = totalNo;
    }

    public Page(Integer pageNo, Integer pageSize) {
        if(pageNo <= 0){
            this.pageNo = 1;
        }else {
            this.pageNo = pageNo;
        }
        if(pageSize<=0){
            this.pageSize = 10;
        }else{
            this.pageSize = pageSize;
        }
    }

    public Integer getStartIndex(){
        return (this.pageNo-1)*this.pageSize;
    }
}
