package by.home.acs.language.hint;

import by.home.acs.language.psi.ACSScriptFunctionInvocation;
import by.home.acs.language.psi.ACSScriptFunctionInvokeParameters;
import by.home.acs.language.psi.ACSScriptNormalFunctionInvocation;
import com.intellij.codeInsight.hints.InlayInfo;
import com.intellij.codeInsight.hints.InlayParameterHintsProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;

import java.util.*;

//Not implemented.
public class ACSBuiltInMethodHint implements InlayParameterHintsProvider {
    @Override
    public @NotNull
    List<InlayInfo> getParameterHints(@NotNull PsiElement element) {
        if (!(element instanceof ACSScriptFunctionInvocation)) return Collections.emptyList();
        List<InlayInfo> inlayInfos = doGetParameterList(element);
        return inlayInfos;
    }

    @Override
    public @NotNull
    List<InlayInfo> getParameterHints(@NotNull PsiElement element, @NotNull PsiFile file) {
        return InlayParameterHintsProvider.super.getParameterHints(element, file);
    }

    @Override
    public @NotNull
    Set<String> getDefaultBlackList() {
        //here we add methods or something like that in packages to exclude hints.
        Set<String> set = new HashSet<>();
        set.add("*.print(*)");
        return set;
    }

    private List<InlayInfo> doGetParameterList(PsiElement element) {
        if (!(element instanceof ACSScriptFunctionInvocation)) return Collections.emptyList();
        ACSScriptNormalFunctionInvocation normalFunctionInvocation = ((ACSScriptFunctionInvocation) element).getNormalFunctionInvocation();
        assert normalFunctionInvocation != null;
        List<ACSScriptFunctionInvokeParameters> functionInvokeParametersList = normalFunctionInvocation.getFunctionInvokeParametersList();
        List<InlayInfo> hints = new ArrayList<>();
        functionInvokeParametersList.forEach(acsScriptFunctionInvokeParameters -> {
            //check normally offset, not just 1
            hints.add(new InlayInfo(acsScriptFunctionInvokeParameters.getText(), 1));
        });
        return hints;
    }
}
