package SqlEngine.Parser;

/** */
/**
 *
 * 单句插入语句解析器
 */
public class ShowSqlParser extends BaseSingleSqlParser {
    public ShowSqlParser(String originalSql) {
        super(originalSql);
    }

    @Override
    protected void initializeSegments() {
        segments.add(new SqlSegment("(show)(.+)(;)", "[,]"));
        segments.add(new SqlSegment("(tables|databases)(.+)(;)", "[,]"));
    }

    @Override
    public String getParsedSql() {
        String retval = super.getParsedSql();
        retval = retval + ")";
        return retval;
    }
}