package by.home.acs.language.method;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

public class ACSBuiltInMethods {
    private static final Set<String> allMethods;

    static {
        Set<String> methods = new ConcurrentSkipListSet<>();
        methods.add("print");
        methods.add("ACS_NamedExecuteWithResult");
        methods.add("ACS_NamedExecute");
        allMethods = Collections.unmodifiableSet(methods);
    }

    public static boolean isBuiltInMethod(String functionNameID) {
        return allMethods.stream().anyMatch(functionNameID::equalsIgnoreCase);
    }
}
