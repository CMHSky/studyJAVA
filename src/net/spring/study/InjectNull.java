package net.spring.study;

public class InjectNull {
    private String pNull;
    private String pEmpty;
    private String pLiteral;
    private Grade2 dependBean;

    public void setpNull(String pNull) {
        this.pNull = pNull;
    }

    public void setpEmpty(String pEmpty) {
        this.pEmpty = pEmpty;
    }

    public void setpLiteral(String pLiteral) {
        this.pLiteral = pLiteral;
    }

    public void setDependBean(Grade2 dependBean) {
        this.dependBean = dependBean;
    }

    public Grade2 getDependBean() {
        return dependBean;
    }

    @Override
    public String toString() {
        return "InjectNull{" +
                "pNull='" + pNull + '\'' +
                ", pEmpty='" + pEmpty + '\'' +
                ", pLiteral='" + pLiteral + '\'' +
                ", dependBean=" + dependBean +
                '}';
    }
}
