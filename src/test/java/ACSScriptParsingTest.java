import by.home.acs.language.ACSScriptFileDefinition;
import com.intellij.testFramework.ParsingTestCase;

public class ACSScriptParsingTest extends ParsingTestCase {
    public ACSScriptParsingTest() {
        super("", "acs", new ACSScriptFileDefinition());
    }

    public void testParsingTestData() {
        doTest(true);
    }

    @Override
    protected String getTestDataPath() {
        return "src/test/testData";
    }


    @Override
    protected boolean skipSpaces() {
        return false;
    }

    @Override
    protected boolean includeRanges() {
        return true;
    }
}
