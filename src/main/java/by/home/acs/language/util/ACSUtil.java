package by.home.acs.language.util;

import by.home.acs.language.ACSScriptType;
import by.home.acs.language.method.ACSBuiltInMethodLoader;
import by.home.acs.language.method.ACSTypeCastMethodLoader;
import by.home.acs.language.method.ACSZspecialMethodLoader;
import by.home.acs.language.psi.*;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class ACSUtil {
    public static List<ACSScriptScriptDefinition> findScript(Project project, String number) {
        List<ACSScriptScriptDefinition> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(by.home.acs.language.ACSScriptType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            ACSScriptFile acsFile = (ACSScriptFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (acsFile != null) {
                ACSScriptDefinition[] scriptWord = PsiTreeUtil.getChildrenOfType(acsFile, ACSScriptDefinition.class);
                if (scriptWord != null) {
                    for (ACSScriptDefinition acs : scriptWord) {
                        ACSScriptScriptDefinition scriptDefinition = acs.getScriptDefinition();
                        if (scriptDefinition != null) {
                            if (scriptDefinition.getScriptName().textMatches(number)) {
                                result.add(scriptDefinition);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    public static List<ACSScriptFunctionDefinition> findFunctionDefinition(Project project, String functionName) {
        List<ACSScriptFunctionDefinition> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(by.home.acs.language.ACSScriptType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            ACSScriptFile acsFile = (ACSScriptFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (acsFile != null) {
                ACSScriptDefinition[] functionDefinitions = PsiTreeUtil.getChildrenOfType(acsFile, ACSScriptDefinition.class);
                if (functionDefinitions != null) {
                    for (ACSScriptDefinition acs : functionDefinitions) {
                        ACSScriptFunctionDefinition functionDefinition = acs.getFunctionDefinition();
                        if (functionDefinition != null) {
                            if (functionDefinition.getFunctionName().textMatches(functionName)) {
                                result.add(functionDefinition);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    public static List<ACSScriptFunctionDefinition> findFunctionDefinition(Project project) {
        List<ACSScriptFunctionDefinition> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(by.home.acs.language.ACSScriptType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            ACSScriptFile acsFile = (ACSScriptFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (acsFile != null) {
                ACSScriptDefinition[] functionDefinitions = PsiTreeUtil.getChildrenOfType(acsFile, ACSScriptDefinition.class);
                List<ACSScriptFunctionDefinition> foundFunctionDefinitions = new ArrayList<>();
                if (functionDefinitions != null) {
                    for (ACSScriptDefinition acs : functionDefinitions) {
                        ACSScriptFunctionDefinition functionDefinition = acs.getFunctionDefinition();
                        if (functionDefinition != null) {
                            foundFunctionDefinitions.add(functionDefinition);
                        }
                    }
                }
                result.addAll(foundFunctionDefinitions);
            }
        }
        return result;
    }

    public static List<ACSScriptFunctionInvocation> findFunctionInvocation(Project project, String functionName) {
        List<ACSScriptFunctionInvocation> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(by.home.acs.language.ACSScriptType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            ACSScriptFile acsFile = (ACSScriptFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (acsFile != null) {
                Collection<ACSScriptFunctionInvocation> functionInvocations = PsiTreeUtil.findChildrenOfType(acsFile, ACSScriptFunctionInvocation.class);
                Optional<ACSScriptFunctionInvocation> first = functionInvocations.stream().filter(acsScriptFunctionInvocation -> acsScriptFunctionInvocation.getFunctionName().textMatches(functionName)).findFirst();
                first.ifPresent(result::add);
            }

        }
        return result;
    }


    public static List<ACSScriptDefinition> findScript(Project project) {
        List<ACSScriptDefinition> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(by.home.acs.language.ACSScriptType.INSTANCE, GlobalSearchScope.allScope(project));
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
                FileTypeIndex.getFiles(by.home.acs.language.ACSScriptType.INSTANCE, GlobalSearchScope.allScope(project));
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
                FileTypeIndex.getFiles(by.home.acs.language.ACSScriptType.INSTANCE, GlobalSearchScope.allScope(project));
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

    public static boolean checkPsiElementIsZspecialFunction(PsiElement element) {
        return ACSZspecialMethodLoader.checkZspecialFunction(element.getText());
    }

    public static boolean checkPsiElementIsBuiltInFunction(PsiElement element) {
        return ACSBuiltInMethodLoader.checkBuiltInFunction(element.getText());
    }

    public static boolean checkPsiElementIsTypeCastBuiltInFunction(PsiElement element) {
        return ACSTypeCastMethodLoader.checkTypeCastBuiltInMethod(element.getText());
    }


}