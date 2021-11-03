package by.home.acs.language.search;

import by.home.acs.language.psi.ACSScriptFunctionName;
import com.intellij.util.Processor;
import com.intellij.util.QueryExecutor;
import org.jetbrains.annotations.NotNull;

public class ACSFunctionSearchExecutor implements QueryExecutor<ACSScriptFunctionName, ACSFunctionSearch.SearchParameters> {

    @Override
    public boolean execute(@NotNull ACSFunctionSearch.SearchParameters queryParameters, @NotNull Processor<? super ACSScriptFunctionName> consumer) {
        var functionName = queryParameters.getFunctionReference();
        var project = functionName.getProject();
        return true;
    }
}
