package gov.shenyang.zwfw.dto;

import lombok.Data;

/**
 * ClassName:AdminTreatmentDTO
 * Package:gov.shenyang.zwfw.dto
 * Description:
 *
 * @Date:2020/3/22 上午 10:55
 * @Author:gaochenyu2020@163.com
 */
@Data
public class AdminTreatmentDTO {
    private Long id;
    private String userName;
    private String idCard;
    private String hospital;
    private String treatmentDate;
    private String gmtCreate;
    private String stateMessage;
}
