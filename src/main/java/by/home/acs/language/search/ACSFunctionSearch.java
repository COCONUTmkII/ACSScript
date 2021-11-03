package by.home.acs.language.search;

import by.home.acs.language.psi.ACSScriptFunctionName;
import com.intellij.openapi.extensions.ExtensionPointName;
import com.intellij.psi.search.searches.ExtensibleQueryFactory;
import com.intellij.util.Query;
import com.intellij.util.QueryExecutor;
import org.jetbrains.annotations.NotNull;


public class ACSFunctionSearch extends ExtensibleQueryFactory<ACSScriptFunctionName, ACSFunctionSearch.SearchParameters> {
    public static final ExtensionPointName<QueryExecutor<ACSScriptFunctionName, SearchParameters>> EP_NAME = ExtensionPointName.create("by.home.ACSScript.acsFunctionSearch");
    public static final ACSFunctionSearch INSTANCE = new ACSFunctionSearch();


    private ACSFunctionSearch() {
        super(EP_NAME);
    }

    @NotNull
    public static Query<ACSScriptFunctionName> search(ACSScriptFunctionName reference) {
        return INSTANCE.createUniqueResultsQuery(new SearchParameters(reference));
    }

    protected static class SearchParameters {
        private final ACSScriptFunctionName functionReference;

        public SearchParameters(ACSScriptFunctionName reference) {
            functionReference = reference;
        }

        public ACSScriptFunctionName getFunctionReference() {
            return functionReference;
        }

    }
}
