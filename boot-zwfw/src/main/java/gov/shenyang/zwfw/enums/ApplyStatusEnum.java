package gov.shenyang.zwfw.enums;

/**
 * ClassName:ApplyStausEnum
 * Package:gov.shenyang.zwfw.enums
 * Description:
 *
 * @Date:2020/3/19 下午 4:39
 * @Author:gaochenyu2020@163.com
 */
public enum ApplyStatusEnum {

    APPLY_NOT_DEAL("0","未处理"),
    APPLY_IS_SUCCESS("1","已通过"),
    APPLY_IS_FAIL("2","已驳回");

    private String status;
    private String message;

    ApplyStatusEnum(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public static String messageOfStatus(String status){
        for (ApplyStatusEnum applyStatusEnum : ApplyStatusEnum.values()) {
            if (applyStatusEnum.getStatus().equals(status)){
                return applyStatusEnum.getMessage();
            }
        }
        return "";
    }
}
