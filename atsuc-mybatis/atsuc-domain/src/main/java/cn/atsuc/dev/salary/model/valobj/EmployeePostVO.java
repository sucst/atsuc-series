package cn.atsuc.dev.salary.model.valobj;

/**
 * @author atsuc
 * @date 2024/6/24 21:17
 * @email s202011105851@163.com
 * @description 雇员职位
 */
public enum EmployeePostVO {

    T1("T-1", "初级工程师"),
    T2("T-2", "初级工程师"),
    T3("T-3", "中级工程师"),
    T4("T-4", "中级工程师"),
    T5("T-5", "高级工程师"),
    T6("T-6", "高级工程师"),
    T7("T-7", "架构师"),
    T8("T-8", "架构师");

    private final String code;
    private final String name;

    private EmployeePostVO(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return name;
    }
}
