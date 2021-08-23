package by.home.acs.language.method;

import java.util.Arrays;
import java.util.Objects;

public class ACSMethod {
    private String name;
    private String returnType;
    private String[] parameter;

    public ACSMethod(String name, String returnType, String... parameter) {
        this.name = name;
        this.returnType = returnType;
        this.parameter = parameter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public String[] getParameter() {
        return parameter;
    }

    public void setParameter(String[] parameter) {
        this.parameter = parameter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ACSMethod that = (ACSMethod) o;
        return Objects.equals(name, that.name) && Objects.equals(returnType, that.returnType) && Arrays.equals(parameter, that.parameter);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, returnType);
        result = 31 * result + Arrays.hashCode(parameter);
        return result;
    }
}
