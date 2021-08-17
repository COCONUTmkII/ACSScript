package by.home.acs.language.highlight;

import by.home.acs.language.ACSScriptTypes;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.psi.tree.IElementType;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

import static by.home.acs.language.highlight.ACSScriptTextAttributeKeyValue.*;

public class ACSScriptSyntaxAttributeKeySupplier {
    private static final Map<IElementType, Supplier<TextAttributesKey[]>> IElements;
    static {
        final Map<IElementType, Supplier<TextAttributesKey[]>> elements = new ConcurrentHashMap<>();
        elements.put(ACSScriptTypes.INCLUDE_KEY, () -> new TextAttributesKey[]{KEY});
        elements.put(ACSScriptTypes.IMPORT_KEY, () -> new TextAttributesKey[]{KEY});
        elements.put(ACSScriptTypes.DEFINE_KEY, () -> new TextAttributesKey[]{KEY});
        elements.put(ACSScriptTypes.LIBRARY_KEY, () -> new TextAttributesKey[]{KEY});
        elements.put(ACSScriptTypes.WORLD, () -> new TextAttributesKey[]{KEY});
        elements.put(ACSScriptTypes.GLOBAL, () -> new TextAttributesKey[]{KEY});
        elements.put(ACSScriptTypes.STATIC, () -> new TextAttributesKey[]{KEY});
        elements.put(ACSScriptTypes.SPECIAL, () -> new TextAttributesKey[]{KEY});
        elements.put(ACSScriptTypes.OPEN, () -> new TextAttributesKey[]{SCRIPT_TYPE});
        elements.put(ACSScriptTypes.DEATH, () -> new TextAttributesKey[]{SCRIPT_TYPE});
        elements.put(ACSScriptTypes.ENTER, () -> new TextAttributesKey[]{SCRIPT_TYPE});
        elements.put(ACSScriptTypes.DISCONNECT, () -> new TextAttributesKey[]{SCRIPT_TYPE});
        elements.put(ACSScriptTypes.PICKUP, () -> new TextAttributesKey[]{SCRIPT_TYPE});
        elements.put(ACSScriptTypes.REDRETURN, () -> new TextAttributesKey[]{SCRIPT_TYPE});
        elements.put(ACSScriptTypes.BLUERETURN, () -> new TextAttributesKey[]{SCRIPT_TYPE});
        elements.put(ACSScriptTypes.WHITERETURN, () -> new TextAttributesKey[]{SCRIPT_TYPE});
        elements.put(ACSScriptTypes.CLIENTSIDE, () -> new TextAttributesKey[]{SCRIPT_TYPE});
        elements.put(ACSScriptTypes.REOPEN, () -> new TextAttributesKey[]{SCRIPT_TYPE});
        elements.put(ACSScriptTypes.NET, () -> new TextAttributesKey[]{SCRIPT_TYPE});
        elements.put(ACSScriptTypes.RETURN, () -> new TextAttributesKey[]{KEY});
        elements.put(ACSScriptTypes.EMPTY_STRING, () -> new TextAttributesKey[]{STRING_VALUE});
        elements.put(ACSScriptTypes.RESPAWN, () -> new TextAttributesKey[]{SCRIPT_TYPE});
        elements.put(ACSScriptTypes.UNLOADING, () -> new TextAttributesKey[]{SCRIPT_TYPE});
        elements.put(ACSScriptTypes.SCRIPT, () -> new TextAttributesKey[]{KEY});
        elements.put(ACSScriptTypes.FUNCTION, () -> new TextAttributesKey[]{KEY});
        elements.put(ACSScriptTypes.TERMINATE, () -> new TextAttributesKey[]{KEY});
        elements.put(ACSScriptTypes.SUSPEND, () -> new TextAttributesKey[]{KEY});
        elements.put(ACSScriptTypes.INT, () -> new TextAttributesKey[]{KEY});
        elements.put(ACSScriptTypes.VARIABLE_DEFINITION, () -> new TextAttributesKey[]{KEY});
        elements.put(ACSScriptTypes.STRING, () -> new TextAttributesKey[]{STRING_VALUE});
        elements.put(ACSScriptTypes.BOOL, () -> new TextAttributesKey[]{KEY});
        elements.put(ACSScriptTypes.COMMENT, () -> new TextAttributesKey[]{COMMENT});
        elements.put(ACSScriptTypes.IDENTIFIER, () -> new TextAttributesKey[]{IDENTIFIER});
        elements.put(ACSScriptTypes.VOID, () -> new TextAttributesKey[]{KEY});
        elements.put(ACSScriptTypes.STR, () -> new TextAttributesKey[]{KEY});
        elements.put(ACSScriptTypes.NUMBER, () -> new TextAttributesKey[]{INT_VALUE});
        elements.put(ACSScriptTypes.FLOAT, () -> new TextAttributesKey[]{INT_VALUE});
        elements.put(ACSScriptTypes.BREAK, () -> new TextAttributesKey[]{KEY});
        elements.put(ACSScriptTypes.DEFAULT, () -> new TextAttributesKey[]{KEY});
        elements.put(ACSScriptTypes.IF, () -> new TextAttributesKey[]{KEY});
        elements.put(ACSScriptTypes.ELSE, () -> new TextAttributesKey[]{KEY});
        elements.put(ACSScriptTypes.SWITCH, () -> new TextAttributesKey[]{KEY});
        elements.put(ACSScriptTypes.CASE, () -> new TextAttributesKey[]{KEY});
        elements.put(ACSScriptTypes.FOR, () -> new TextAttributesKey[]{KEY});
        elements.put(ACSScriptTypes.WHILE, () -> new TextAttributesKey[]{KEY});
        elements.put(ACSScriptTypes.DO, () -> new TextAttributesKey[]{KEY});
        elements.put(ACSScriptTypes.UNTIL, () -> new TextAttributesKey[]{KEY});
        IElements = Collections.unmodifiableMap(elements);
    }

    public static TextAttributesKey[] supplyTextAttributeKey(IElementType type) {
        Optional<Supplier<TextAttributesKey[]>> attributeSupplier = Optional.ofNullable(IElements.get(type));
        return attributeSupplier.map(Supplier::get).orElse(new TextAttributesKey[0]);
    }
}
