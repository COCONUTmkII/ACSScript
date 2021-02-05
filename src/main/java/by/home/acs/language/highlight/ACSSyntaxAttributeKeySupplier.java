package by.home.acs.language.highlight;

import by.home.acs.language.ACSScriptTypes;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.psi.tree.IElementType;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

import static by.home.acs.language.highlight.ACSTextAttributeKeyValue.*;

public class ACSSyntaxAttributeKeySupplier {
    private static final Map<IElementType, Supplier<TextAttributesKey[]>> IElements;
    static {
        final Map<IElementType, Supplier<TextAttributesKey[]>> elements = new ConcurrentHashMap<>();
        elements.put(ACSScriptTypes.FUNCTION, () -> new TextAttributesKey[]{KEY});
        elements.put(ACSScriptTypes.VOID, () -> new TextAttributesKey[]{KEY});
        elements.put(ACSScriptTypes.INT, () -> new TextAttributesKey[]{KEY});
        elements.put(ACSScriptTypes.BOOL, () -> new TextAttributesKey[]{KEY});
        elements.put(ACSScriptTypes.STRING, () -> new TextAttributesKey[]{STRING_VALUE});
        elements.put(ACSScriptTypes.COMMENT, () -> new TextAttributesKey[]{COMMENT});
        elements.put(ACSScriptTypes.IDENTIFIER, () -> new TextAttributesKey[]{IDENTIFIER});
        elements.put(ACSScriptTypes.NUMBER, () -> new TextAttributesKey[]{INT_VALUE});
        IElements = Collections.unmodifiableMap(elements);
    }

    public static TextAttributesKey[] supplyTextAttributeKey(IElementType type) {
        Optional<Supplier<TextAttributesKey[]>> attributeSupplier = Optional.ofNullable(IElements.get(type));
        return attributeSupplier.map(Supplier::get).orElse(new TextAttributesKey[0]);
    }
}
