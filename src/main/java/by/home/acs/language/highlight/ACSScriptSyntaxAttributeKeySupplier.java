package by.home.acs.language.highlight;


import by.home.acs.language.ACSScriptTypes;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.psi.tree.IElementType;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

import static by.home.acs.language.highlight.ACSScriptSyntaxHighlighter.*;

public class ACSScriptSyntaxAttributeKeySupplier {
    private static final Map<IElementType, Supplier<TextAttributesKey[]>> IElements;
    static {
        final Map<IElementType, Supplier<TextAttributesKey[]>> elements = new ConcurrentHashMap<>();
        elements.put(ACSScriptTypes.OPEN, () -> new TextAttributesKey[]{KEY});
        elements.put(ACSScriptTypes.DEATH, () -> new TextAttributesKey[]{KEY});
        elements.put(ACSScriptTypes.ENTER, () -> new TextAttributesKey[]{KEY});
        elements.put(ACSScriptTypes.DISCONNECT, () -> new TextAttributesKey[]{KEY});
        elements.put(ACSScriptTypes.REOPEN, () -> new TextAttributesKey[]{KEY});
        elements.put(ACSScriptTypes.RETURN, () -> new TextAttributesKey[]{KEY});
        elements.put(ACSScriptTypes.RESPAWN, () -> new TextAttributesKey[]{KEY});
        elements.put(ACSScriptTypes.SCRIPT, () -> new TextAttributesKey[]{KEY});
        elements.put(ACSScriptTypes.FUNCTION, () -> new TextAttributesKey[]{KEY});
        elements.put(ACSScriptTypes.STR, () -> new TextAttributesKey[]{KEY});
        elements.put(ACSScriptTypes.INT, () -> new TextAttributesKey[]{KEY});
        elements.put(ACSScriptTypes.COMMENT, () -> new TextAttributesKey[]{COMMENT});
        elements.put(ACSScriptTypes.IDENTIFIER, () -> new TextAttributesKey[]{IDENTIFIER});
        IElements = Collections.unmodifiableMap(elements);
    }

    public static TextAttributesKey[] supplyTextAttributeKey(IElementType type) {
        Optional<Supplier<TextAttributesKey[]>> attributeSupplier = Optional.ofNullable(IElements.get(type));
        return attributeSupplier.map(Supplier::get).orElse(new TextAttributesKey[0]);
    }
}
