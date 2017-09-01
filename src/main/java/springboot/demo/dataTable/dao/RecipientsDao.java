/*
 * 文件名：RecipientsDao.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：YMM
 * 修改时间：2017年8月30日
 */

package springboot.demo.dataTable.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import springboot.demo.dataTable.entity.RecipientsEntity;

@Transactional
public interface RecipientsDao extends CrudRepository<RecipientsEntity, Long>,JpaRepository<RecipientsEntity, Long>,JpaSpecificationExecutor<RecipientsEntity> {

	/**
	 * 
	 * Description: 根据发件人姓名查询发件人ID
	 * 
	 * @param name 
	 * @return Long
	 * @see
	 */
	@Query("select re.recId from RecipientsEntity re where re.recName like ?1")
    Long findIdByName(String name);
	
	

}
