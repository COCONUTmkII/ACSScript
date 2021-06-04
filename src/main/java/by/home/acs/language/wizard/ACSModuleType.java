package by.home.acs.language.wizard;

import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.ide.util.projectWizard.WizardContext;
import com.intellij.openapi.module.ModuleType;
import com.intellij.openapi.module.ModuleTypeManager;
import com.intellij.openapi.roots.ui.configuration.ModulesProvider;
import com.intellij.openapi.util.IconLoader;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class ACSModuleType extends ModuleType<ACSModuleBuilder> {

    private static final String ID = "ACS_MODULE_TYPE";

    public ACSModuleType() {
        super(ID);
    }

    public static ACSModuleType getInstance(){
        return (ACSModuleType) ModuleTypeManager.getInstance().findByID(ID);
    }

    @Override
    public @NotNull ACSModuleBuilder createModuleBuilder() {
        return new ACSModuleBuilder();
    }

    @Override
    public @NotNull
    @Nls(capitalization = Nls.Capitalization.Title) String getName() {
        return "ACS Module Type";
    }

    @Override
    public @NotNull
    @Nls(capitalization = Nls.Capitalization.Sentence) String getDescription() {
        return "Example custom module type";
    }

    @Override
    public @NotNull Icon getNodeIcon(boolean isOpened) {
        return IconLoader.getIcon("/icons/acs_icon.png");
    }

    @NotNull
    @Override
    public ModuleWizardStep[] createWizardSteps(@NotNull WizardContext wizardContext, @NotNull ACSModuleBuilder moduleBuilder, @NotNull ModulesProvider modulesProvider) {
        return super.createWizardSteps(wizardContext, moduleBuilder, modulesProvider);
    }
}
