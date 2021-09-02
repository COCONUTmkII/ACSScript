package by.home.acs.language.method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ACSMethod {
    private String name;
    private String returnType;
    private List<String> parameter = new ArrayList<>();

    public ACSMethod(String name, String returnType, String... parameter) {
        this.name = name;
        this.returnType = returnType;
        this.parameter.addAll(Arrays.asList(parameter));
    }

    public ACSMethod(String name, String returnType, List<String> typeCastParameters) {
        this.name = name;
        this.returnType = returnType;
        this.parameter = typeCastParameters;
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

    public List<String> getParameter() {
        return parameter;
    }

    public void setParameter(List<String> parameter) {
        this.parameter = parameter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ACSMethod acsMethod = (ACSMethod) o;
        return Objects.equals(name, acsMethod.name) && Objects.equals(returnType, acsMethod.returnType) && Objects.equals(parameter, acsMethod.parameter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, returnType, parameter);
    }
}
