package gov.shenyang.zwfw.dto;

import lombok.Data;

import java.util.List;

/**
 * ClassName:PaginationDTO
 * Package:gov.shenyang.zwfw.dto
 * Description:
 *
 * @Date:2020/3/12 下午 8:17
 * @Author:gaochenyu2020@163.com
 */
@Data
public class PaginationDTO<T> {
    private Integer code = 0;
    private String msg = "";
    private Integer count;
    private List<T> data;
}
