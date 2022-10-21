package net.spring.study;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Grade2 {
    private static final Log LOGGER = LogFactory.getLog(Grade2.class);
    private Integer gradeId;
    private String gradeName;

    // 无参构造函数
    // 若该类中不存在其他的带参构造函数，则这个默认的无参构造函数可以省略
    public Grade2() {
    }

    public void setGradeId(Integer gradeId) {
//        LOGGER.info("正在执行 Grade2 类的 setGradeId() 方法…… ");
        this.gradeId = gradeId;
    }

    public void setGradeName(String gradeName) {
//        LOGGER.info("正在执行 Grade2 类的 setGradeName() 方法…… ");
        this.gradeName = gradeName;
    }

    @Override
    public String toString() {
        return "Grade2{" +
                "gradeId=" + gradeId +
                ", gradeName='" + gradeName + '\'' +
                '}';
    }
}
