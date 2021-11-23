package by.home.acs.language.stub.function;

import by.home.acs.language.psi.ACSFunctionElement;
import by.home.acs.language.stub.index.ACSStubIndexKeys;
import com.intellij.openapi.project.Project;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.stubs.StringStubIndexExtension;
import com.intellij.psi.stubs.StubIndex;
import com.intellij.psi.stubs.StubIndexKey;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class ACSStubFunctionIndex extends StringStubIndexExtension<ACSFunctionElement> {
    public static final ACSStubFunctionIndex INSTANCE = new ACSStubFunctionIndex();

    @Override
    public @NotNull StubIndexKey<String, ACSFunctionElement> getKey() {
        return ACSStubIndexKeys.FUNCTIONS;
    }

    public static ACSStubFunctionIndex getInstance() {
        return INSTANCE;
    }

    @Override
    public Collection<ACSFunctionElement> get(@NotNull String s, @NotNull Project project, @NotNull GlobalSearchScope scope) {
        return StubIndex.getElements(getKey(), s, project, scope, ACSFunctionElement.class);
    }
}
