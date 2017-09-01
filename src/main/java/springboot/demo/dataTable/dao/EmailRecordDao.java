/*
 * 文件名：EmailRecordDao.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：YMM
 * 修改时间：2017年8月30日
 */

package springboot.demo.dataTable.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import springboot.demo.dataTable.entity.EmailRecordEntity;


/**
 * 
 * 邮件发送记录Dao
 * 〈功能详细描述〉
 * @author HCN
 * @version 2017年8月31日
 * @see EmailRecordDao
 * @since
 */
public interface EmailRecordDao extends CrudRepository<EmailRecordEntity, Long>,JpaRepository<EmailRecordEntity, Long> {

    /**
     * 
     * Description: 根据查询条件查询所有的记录
     * @param querySpecifi 
     * @param pageable 
     * @return Page<EmailRecordEntity>
     * @see
     */
    Page<EmailRecordEntity> findAll(Specification<EmailRecordEntity> querySpecifi, Pageable pageable);
    
}
