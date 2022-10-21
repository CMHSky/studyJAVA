package net.spring.study;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Student2 {
    private static final Log LOGGER = LogFactory.getLog(Student2.class);
    private int id;
    private String name;
    private Grade2 grade;

    public Student2() {
    }

    public void setId(int id) {
//        LOGGER.info("正在执行 Student2 类的 setId() 方法…… ");
        this.id = id;
    }

    public void setName(String name) {
//        LOGGER.info("正在执行 Student2 类的 setName() 方法…… ");
        this.name = name;
    }

    public void setGrade(Grade2 grade) {
//        LOGGER.info("正在执行 Student2 类的 setGrade() 方法…… ");
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
