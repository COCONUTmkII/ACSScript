package by.home.acs.language.inspection;

import com.intellij.DynamicBundle;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.PropertyKey;

import java.util.function.Supplier;

public class ACSInspectionBundle extends DynamicBundle {
    @NonNls
    private static final String BUNDLE = "inspectionBundle.ACSInspectionBundle";
    private static final ACSInspectionBundle INSTANCE = new ACSInspectionBundle();

    private ACSInspectionBundle() {
        super(BUNDLE);
    }

    @NotNull
    public static String message(@NotNull @PropertyKey(resourceBundle = BUNDLE) String key, @NotNull Object... params) {
        return INSTANCE.getMessage(key, params);
    }

    @NotNull
    public static Supplier<String> messagePointer(@NotNull @PropertyKey(resourceBundle = BUNDLE) String key, @NotNull Object... params) {
        return INSTANCE.getLazyMessage(key, params);
    }
}
