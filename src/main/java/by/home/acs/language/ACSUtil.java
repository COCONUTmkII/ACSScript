package by.home.acs.language;

//import by.home.acs.language.psi.ACSScriptDefinition;

import by.home.acs.language.psi.*;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ACSUtil {
    public static List<ACSScriptDefinition> findScript(Project project, String number) {
        List<ACSScriptDefinition> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(ACSScriptType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            ACSScriptFile acsFile = (ACSScriptFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (acsFile != null) {
                ACSScriptDefinition[] scriptWord = PsiTreeUtil.getChildrenOfType(acsFile, ACSScriptDefinition.class);
                if (scriptWord != null) {
                    for (ACSScriptDefinition acs : scriptWord) {
                        if (number.equals(acs.getText())) {
                            result.add(acs);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static List<ACSScriptDefinition> findScript(Project project) {
        List<ACSScriptDefinition> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(ACSScriptType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            ACSScriptFile acsFile = (ACSScriptFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (acsFile != null) {
                ACSScriptDefinition[] scriptWord = PsiTreeUtil.getChildrenOfType(acsFile, ACSScriptDefinition.class);
                if (scriptWord != null) {
                    Collections.addAll(result, scriptWord);
                }
            }
        }
        return result;
    }

    public static List<ACSScriptScriptDefinition> findIdentifiers(Project project, String identifier) {
        List<ACSScriptScriptDefinition> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(ACSScriptType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            ACSScriptFile acsFile = (ACSScriptFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (acsFile != null) {
                ACSScriptScriptDefinition[] scriptWord = PsiTreeUtil.getChildrenOfType(acsFile, ACSScriptScriptDefinition.class);
                if (scriptWord != null) {
                    Collections.addAll(result, scriptWord);
                }
            }
        }
        return result;
    }

    public static List<ACSScriptScriptBody> findScriptBody(Project project) {
        List<ACSScriptScriptBody> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(ACSScriptType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            ACSScriptFile acsScriptFile = (ACSScriptFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (acsScriptFile != null) {
                ACSScriptScriptBody[] scriptBodies = PsiTreeUtil.getChildrenOfType(acsScriptFile, ACSScriptScriptBody.class);
                if (scriptBodies != null) {
                    Collections.addAll(result, scriptBodies);
                }
            }
        }
        return result;
    }

    public static List<ACSScriptScriptName> findScriptName(Project project) {
        List<ACSScriptScriptName> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(ACSScriptType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            ACSScriptFile acsScriptFile = (ACSScriptFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (acsScriptFile != null) {
                @NotNull Collection<ACSScriptScriptName> scriptNames = PsiTreeUtil.findChildrenOfAnyType(acsScriptFile, ACSScriptScriptName.class);
                result.addAll(scriptNames);
            }
        }
        return result;
    }
}