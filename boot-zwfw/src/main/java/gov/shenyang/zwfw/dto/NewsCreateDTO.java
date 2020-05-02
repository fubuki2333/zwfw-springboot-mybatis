package gov.shenyang.zwfw.dto;

import lombok.Data;

/**
 * ClassName:NewsCreateDTO
 * Package:gov.shenyang.zwfw.dto
 * Description:
 *
 * @Date:2020/3/16 下午 10:51
 * @Author:gaochenyu2020@163.com
 */
@Data
public class NewsCreateDTO {
    private String title;
    private String author;
    private String content;
}
