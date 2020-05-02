package gov.shenyang.zwfw.dto;

import lombok.Data;

/**
 * ClassName:NewsDTO
 * Package:gov.shenyang.zwfw.dto
 * Description:
 *
 * @Date:2020/3/22 上午 11:28
 * @Author:gaochenyu2020@163.com
 */
@Data
public class NewsDTO {
    private Long id;
    private String title;
    private String author;
    private String content;
    private String createDate;
}
