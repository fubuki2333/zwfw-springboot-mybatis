package gov.shenyang.zwfw.dto;

import lombok.Data;

/**
 * ClassName:AdminApplyDTO
 * Package:gov.shenyang.zwfw.dto
 * Description:
 *
 * @Date:2020/3/13 下午 9:00
 * @Author:gaochenyu2020@163.com
 */
@Data
public class AdminApplyDTO {
    private Long id;
    private Long userId;
    private String userName;
    private String idCard;
    private String idCardPic;
    private String careCard;
    private String careCardPic;
    private String prescriptionPic;
    private String invoicePic;
    private String stateMessage;
    private String treatmentDate;
    private String gmtCreate;
}
