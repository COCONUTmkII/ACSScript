package by.home.acs.language;

import by.home.acs.language.psi.ACSScriptDefinition;
import by.home.acs.language.psi.ACSScriptFile;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ACSUtil {
    public static List<ACSScriptDefinition> findFunctionReturnType(Project project, String type) {
        List<ACSScriptDefinition> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(ACSScriptType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            ACSScriptFile ACSFile = (ACSScriptFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (ACSFile != null) {
                ACSScriptDefinition[] definitions = PsiTreeUtil.getChildrenOfType(ACSFile, ACSScriptDefinition.class);
                if (definitions != null) {
                    for (ACSScriptDefinition definition : definitions) {
                        if (type.equals(definition.getFunctionReturnType())) {
                            result.add(definition);
                        }
                    }
                }
            }
        }
        return result;
    }

}
