package SqlEngine.Parser;

/** *//**
 *
 * 单句插入语句解析器
 */
public class UseSqlParser extends BaseSingleSqlParser{
    public UseSqlParser(String originalSql) {
        super(originalSql);
    }
    @Override
    protected void initializeSegments() {
        segments.add(new SqlSegment("(use)(.+)(;)","[,]"));
    }
    @Override
    public String getParsedSql() {
        String retval=super.getParsedSql();
        retval=retval+")";
        return retval;
    }
}