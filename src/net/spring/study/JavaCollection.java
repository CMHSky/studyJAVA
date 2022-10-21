package net.spring.study;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JavaCollection {
    // 数组类型属性
    private String[] array;
    // list 集合类型属性
    private List<String> list;
    // map 集合类型属性
    private Map<String, String> maps;
    // set 集合类型属性
    private Set<String> sets;

    public void setArray(String[] array) {
        this.array = array;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }

    @Override
    public String toString() {
        return "JavaCollection{" +
                "array=" + Arrays.toString(array) +
                ", list=" + list +
                ", maps=" + maps +
                ", sets=" + sets +
                '}';
    }
}
