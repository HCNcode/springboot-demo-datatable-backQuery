/*
 * 文件名：EmailRecordService.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：YMM
 * 修改时间：2017年8月30日
 */

package springboot.demo.dataTable.service;

import springboot.demo.dataTable.entity.SearchEmailRecord;

/**
 * 
 * 邮件发送记录service层
 * 〈功能详细描述〉
 * @author HCN
 * @version 2017年8月31日
 * @see EmailRecordService
 * @since
 */
public interface EmailRecordService {
    
    /**
     * 
     * Description: 按条件查询发送记录
     * 
     * @param searchEmailRecord 查询条件封装类
     * @param start 开始页数
     * @param length 每页条数
     * @param draw ""
     * @return  ""
     * @see
     */
    String findEmailRecordList(SearchEmailRecord searchEmailRecord, Integer start, Integer length, String draw);

}
