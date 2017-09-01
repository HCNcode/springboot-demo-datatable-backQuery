/*
 * 文件名：SearchEmailRecord.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：HCN
 * 修改时间：2017年8月31日
 */

package springboot.demo.dataTable.entity;


/**
 * 
 * 查询发送记录的封装类
 * 实现按是否成功和收件人姓名进行查询
 * @author HCN
 * @version 2017年8月31日
 * @see SearchEmailRecord
 * @since
 */
public class SearchEmailRecord {

    /**
     * 是否成功
     */
    private Integer result;
    
    /**
     * 收件人姓名
     */
    private String recipients;
    
    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getRecipients() {
        return recipients;
    }

    public void setRecipients(String recipients) {
        this.recipients = recipients;
    }

    
    
}
