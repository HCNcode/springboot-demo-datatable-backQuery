/*
 * 文件名：EmailRecordEnitity.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：yuanpeng
 * 修改时间：2017年8月6日
 */

package springboot.demo.dataTable.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * 
 * 邮件内容记录表
 * @author yuanpeng
 * @version 2017年8月6日
 * @see EmailRecordEnitity
 * @since
 */
@Entity
public class EmailRecordEntity {

    /**
     * 表id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long erId;
    
    /**
     * 收件人
     */
    @ManyToOne
    private RecipientsEntity recipientsEntity;
    
    /**
     * 邮件内容
     */
    private String comment;
    
    /**
     * 发送时间
     */
    private Date sendTime;
    
    /**
     * 是否成功
     */
    private Integer result;
    
    /**
     * 失败原因
     */
    private String remark;

    public Long getErId() {
        return erId;
    }

    public void setErId(Long erId) {
        this.erId = erId;
    }

    public RecipientsEntity getRecipientsEntity() {
        return recipientsEntity;
    }

    public void setRecipientsEntity(RecipientsEntity recipientsEntity) {
        this.recipientsEntity = recipientsEntity;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

   
    
}
