package by.home.acs.language.method;


import java.util.*;
import java.util.stream.Collectors;

public class ACSTypeCastMethodLoader {
    private static final Set<ACSMethod> methods;
    public static final List<String> typeCastParameters = List.of("s", "i", "d", "b", "c", "f", "k", "l", "h", "n", "a");

    static {
        final Set<ACSMethod> methodSet = new HashSet<>();
        methodSet.add(new ACSMethod("Print", "void", typeCastParameters));
        methodSet.add(new ACSMethod("PrintBold", "void", typeCastParameters));
        methodSet.add(new ACSMethod("Log", "void", typeCastParameters));
        methodSet.add(new ACSMethod("HudMessage", "void", typeCastParameters));
        methodSet.add(new ACSMethod("HudMessageBold", "void", typeCastParameters));
        methods = Collections.unmodifiableSet(methodSet);
    }


    public static boolean checkTypeCastBuiltInMethod(String functionName) {
        return methods.stream().anyMatch(acsMethod -> acsMethod.getName().equalsIgnoreCase(functionName));
    }

    public static List<String> getMethodParameters(String functionName) {
        return methods.stream().filter(acsMethod -> acsMethod.getName().equals(functionName)).map(ACSMethod::getParameter).flatMap(Collection::stream).collect(Collectors.toList());
    }


}