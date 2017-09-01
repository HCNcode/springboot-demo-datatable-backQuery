/*
 * 文件名：EmailRecordServiceImpl.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：YMM
 * 修改时间：2017年8月30日
 */

package springboot.demo.dataTable.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import springboot.demo.dataTable.dao.EmailRecordDao;
import springboot.demo.dataTable.dao.RecipientsDao;
import springboot.demo.dataTable.entity.EmailRecordEntity;
import springboot.demo.dataTable.entity.SearchEmailRecord;
import springboot.demo.dataTable.service.EmailRecordService;
import springboot.demo.dataTable.util.ResultPager;

/**
 * 
 * emailRecordService实现类
 * 〈功能详细描述〉
 * @author HCN
 * @version 2017年8月31日
 * @see EmailRecordServiceImpl
 * @since
 */
@Service("emailRecordService")
public class EmailRecordServiceImpl implements EmailRecordService {

    /**
     * RecipientsDao 用于根据名字来查询id，以实现按收件人查询
     */
    @Autowired
    private RecipientsDao recipientsDao;
    
    /**
     * 注入EmailRecordDao
     */
    @Autowired
    private EmailRecordDao  emailRecordDao;
    
    
    
    @Override
    public String findEmailRecordList(SearchEmailRecord searchEmailRecord, Integer start, Integer length, String draw){
        
        PageRequest pageRequest=null;
        Map<String,Object> resultMap=new HashMap<>();
        //按发送时间降序排序
        Sort sort = new Sort(Sort.Direction.DESC,"sendTime");  
        if(start==null){
            pageRequest=ResultPager.buildPageRequest(start, length,sort);
        }else{
            pageRequest=ResultPager.buildPageRequest(start/length+1, length,sort);
        }
        
        //根据查询条件查询
        Specification<EmailRecordEntity> querySpecifi=emailRecordSearch(searchEmailRecord);
        //分页
        Page<EmailRecordEntity> tenList=this.emailRecordDao.findAll(querySpecifi,pageRequest);
        resultMap.put("draw",draw);
        resultMap.put("recoredsTotal",tenList.getTotalElements());
        resultMap.put("recordsFiltered", tenList.getTotalElements());
        resultMap.put("data", tenList.getContent());
        return JSON.toJSONString(resultMap,SerializerFeature.DisableCircularReferenceDetect);

    }
    
    /**
     * 
     * 查询的语句
     * 
     * @param searchEmailRecord 封装查询类
     * @return  querySpecifi
     * @see
     */
    private Specification<EmailRecordEntity> emailRecordSearch(SearchEmailRecord searchEmailRecord) {
      //封装查询参数
        Specification<EmailRecordEntity> querySpecifi = new Specification<EmailRecordEntity>() {
            //内部类
            @Override
            public Predicate toPredicate(Root<EmailRecordEntity> root, CriteriaQuery<?> query,
                                         CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                if (searchEmailRecord.getResult()!=null) {
                    predicates.add(cb.equal(root.<Integer> get("result"), searchEmailRecord.getResult()));
                    //还可以模糊查询，例如http://blog.csdn.net/han1196639488/article/details/54909100
                    //predicates.add(cb.like(root.<String> get("tenantName"),"%"+searchdisTenant.getTenantName()+"%"));
                }
                
                if(StringUtils.isNotBlank(searchEmailRecord.getRecipients())){
                    //先根据姓名去RecipientsEntity表查出id,然后比较
                    String name = searchEmailRecord.getRecipients();
                    Long id = recipientsDao.findIdByName(name);
                    predicates.add(cb.equal(root.<Long> get("recipientsEntity"),id));
                }
                return cb.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        return querySpecifi;
    }

    


}
