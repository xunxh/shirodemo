package com.itframe.utils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public class PageUtil {
    /**
     * 将PageInfo对象泛型中的Po对象转化为Vo对象
     * @param pageInfoPo PageInfo<Po>对象</>
     * @param <P> Po类型
     * @param <V> Vo类型
     * @return
     */
    public static <P, V> PageInfo<V> PageInfo2PageInfoVo(PageInfo<P> pageInfoPo) {
        // 创建Page对象，实际上是一个ArrayList类型的集合
        Page<V> page = new Page<>(pageInfoPo.getPageNum(), pageInfoPo.getPageSize());
        page.setTotal(pageInfoPo.getTotal());
        return new PageInfo<>(page);
    }

    //对list进行分页
    public static <T> PageInfo<T> startPage(List<T> list, Integer pageNum, Integer pageSize) {
        //创建Page类
        com.github.pagehelper.Page page = new com.github.pagehelper.Page(pageNum, pageSize);
        //为Page类中的total属性赋值
        page.setTotal(list.size());
        //计算当前需要显示的数据下标起始值
        int startIndex = (pageNum - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, list.size());
        //从链表中截取需要显示的子链表，并加入到Page
        page.addAll(list.subList(startIndex, endIndex));
        //以Page创建PageInfo
        PageInfo pageInfo = new PageInfo<>(page);
        return pageInfo;
    }

}
