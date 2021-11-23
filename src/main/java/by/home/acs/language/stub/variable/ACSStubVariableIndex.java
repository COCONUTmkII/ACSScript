package by.home.acs.language.stub.variable;

import by.home.acs.language.psi.ACSVariableElement;
import by.home.acs.language.stub.index.ACSStubIndexKeys;
import com.intellij.openapi.project.Project;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.stubs.StringStubIndexExtension;
import com.intellij.psi.stubs.StubIndex;
import com.intellij.psi.stubs.StubIndexKey;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class ACSStubVariableIndex extends StringStubIndexExtension<ACSVariableElement> {
    public static final ACSStubVariableIndex INSTANCE = new ACSStubVariableIndex();

    @Override
    public @NotNull
    StubIndexKey<String, ACSVariableElement> getKey() {
        return ACSStubIndexKeys.VARIABLES;
    }

    public static ACSStubVariableIndex getInstance() {
        return INSTANCE;
    }


    @Override
    public Collection<ACSVariableElement> get(@NotNull String s, @NotNull Project project, @NotNull GlobalSearchScope scope) {
        return StubIndex.getElements(getKey(), s, project, scope, ACSVariableElement.class);
    }

}
