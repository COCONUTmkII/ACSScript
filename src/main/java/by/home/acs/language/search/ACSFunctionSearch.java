package by.home.acs.language.search;

import by.home.acs.language.reference.ACSFunctionReference;
import com.intellij.psi.search.searches.ExtensibleQueryFactory;
import com.intellij.util.Query;

//I have no idea what am I doing
public class ACSFunctionSearch extends ExtensibleQueryFactory<ACSFunctionReference, ACSFunctionSearch.Something> {
    public static final ACSFunctionSearch INSTANCE = new ACSFunctionSearch();


    protected static class Something {
        private final ACSFunctionReference functionReference;
        private final boolean isDeap;

        public Something(ACSFunctionReference reference, boolean deep) {
            functionReference = reference;
            isDeap = deep;
        }


        public static Query<ACSFunctionReference> search(ACSFunctionReference reference, boolean isDead) {
            return INSTANCE.createUniqueResultsQuery(new Something(reference, isDead));
        }

    }
}
