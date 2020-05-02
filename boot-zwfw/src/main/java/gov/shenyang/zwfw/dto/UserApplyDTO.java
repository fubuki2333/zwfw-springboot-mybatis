package gov.shenyang.zwfw.dto;

import lombok.Data;

/**
 * ClassName:ApplyDTO
 * Package:gov.shenyang.zwfw.dto
 * Description:
 *
 * @Date:2020/3/12 下午 6:51
 * @Author:gaochenyu2020@163.com
 */
@Data
public class UserApplyDTO {
    private Long id;
    private String type;
    private String gmtCreate;
    private String stateMessage;
    private String creator;
}
