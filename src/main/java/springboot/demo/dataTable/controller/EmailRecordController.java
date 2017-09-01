/*
 * 文件名：EmailRecordController.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：YMM
 * 修改时间：2017年8月30日
 */

package springboot.demo.dataTable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import springboot.demo.dataTable.entity.SearchEmailRecord;
import springboot.demo.dataTable.service.EmailRecordService;

/**
 * 
 * 邮件发送记录查询 Controller
 * 〈功能详细描述〉
 * @author HCN
 * @version 2017年8月31日
 * @see EmailRecordController
 * @since
 */
@Controller
public class EmailRecordController {

    /**
     * emailRecordService
     */
    @Autowired
    private EmailRecordService emailRecordService;
   
    /**
     * 页面展示
     */
    @RequestMapping(value={"/show"},method=RequestMethod.GET)
    public String show(){
        return "email_record";
    }
    
    /**
     * 
     * 按条件查询邮件发送记录
     * 
     * @param searchEmailRecord 查询条件封装类
     * @param start 开始页数
     * @param length 每页条数
     * @param draw ""
     * @return  ""
     * @see
     */
    @RequestMapping(value={"email/findEmailRecordList"}, method = RequestMethod.GET)
    @ResponseBody
    public String findEmailRecordList(SearchEmailRecord searchEmailRecord,Integer start,String draw,Integer length){
        return emailRecordService.findEmailRecordList(searchEmailRecord, start, length, draw);
   
    }
    
    
}

