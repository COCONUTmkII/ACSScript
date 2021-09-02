package by.home.acs.language.hint;

import by.home.acs.language.method.ACSTypeCastMethodLoader;
import by.home.acs.language.psi.ACSScriptMixedCastFunctionInvocation;
import by.home.acs.language.psi.ACSScriptTypeCast;
import by.home.acs.language.psi.ACSScriptTypeCastFunctionInvocation;
import com.intellij.codeInsight.hints.InlayInfo;
import com.intellij.codeInsight.hints.InlayParameterHintsProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

import static by.home.acs.language.hint.TypeCastParameter.*;

public class ACSTypeCastMethodHint implements InlayParameterHintsProvider {
    private static final Map<String, Supplier<InlayInfo>> parameters;
    private static PsiElement currentTypeCast;

    static {
        final Map<String, Supplier<InlayInfo>> elements = new ConcurrentHashMap<>();
        elements.put(STRING, () -> new InlayInfo("string", getTypeCastParameterOffset(currentTypeCast), false));
        elements.put(INTEGER, () -> new InlayInfo("integer", getTypeCastParameterOffset(currentTypeCast), false));
        elements.put(DECIMAL, () -> new InlayInfo("integer", getTypeCastParameterOffset(currentTypeCast), false));
        elements.put(BINARY_NUMBER, () -> new InlayInfo("binary", getTypeCastParameterOffset(currentTypeCast), false));
        elements.put(CHARACTER, () -> new InlayInfo("character", getTypeCastParameterOffset(currentTypeCast), false));
        elements.put(FIXED_POINT_NUMBER, () -> new InlayInfo("fixed", getTypeCastParameterOffset(currentTypeCast), false));
        elements.put(KEY, () -> new InlayInfo("key", getTypeCastParameterOffset(currentTypeCast), false));
        elements.put(LANGUAGE, () -> new InlayInfo("language", getTypeCastParameterOffset(currentTypeCast), false));
        elements.put(HEXADECIMAL, () -> new InlayInfo("hex", getTypeCastParameterOffset(currentTypeCast), false));
        elements.put(NAME, () -> new InlayInfo("name", getTypeCastParameterOffset(currentTypeCast), false));
        elements.put(ARRAY, () -> new InlayInfo("array", getTypeCastParameterOffset(currentTypeCast), false));
        parameters = Collections.unmodifiableMap(elements);
    }

    public static InlayInfo checkTypeCastParameters(String parameter) {
        Optional<Supplier<InlayInfo>> inlayInfoSupplier = Optional.ofNullable(parameters.get(parameter));
        return inlayInfoSupplier.map(Supplier::get).orElse(null);
    }

    @Override
    public @NotNull
    List<InlayInfo> getParameterHints(@NotNull PsiElement element) {
        if (element instanceof ACSScriptTypeCastFunctionInvocation || element instanceof ACSScriptMixedCastFunctionInvocation) {
            List<InlayInfo> inlayInfos = doGetParameterList(element);
            return inlayInfos;
        } else {
            return Collections.emptyList();
        }

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
        String functionName = element.getFirstChild().getText();
        boolean isTypeCastBuiltIn = ACSTypeCastMethodLoader.checkTypeCastBuiltInMethod(functionName);
        if (isTypeCastBuiltIn) {
            List<InlayInfo> hints = new ArrayList<>();
            List<ACSScriptTypeCast> typeCast = new ArrayList<>();
            if (element instanceof ACSScriptMixedCastFunctionInvocation) {
                typeCast = ((ACSScriptMixedCastFunctionInvocation) element).getMixedCastFunctionInvokeParameters().getTypeCastList();
            }
            if (element instanceof ACSScriptTypeCastFunctionInvocation) {
                typeCast = ((ACSScriptTypeCastFunctionInvocation) element).getTypeCastFunctionInvokeParameters().getTypeCastList();
            }
            typeCast.forEach(acsScriptTypeCast -> {
                ACSTypeCastMethodHint.currentTypeCast = acsScriptTypeCast;
                hints.add(checkTypeCastParameters(acsScriptTypeCast.getText()));
            });
            return hints;
        }
        return Collections.emptyList();
    }

    private static int getTypeCastParameterOffset(PsiElement element) {
        return element.getTextOffset() + 2;
    }
}
