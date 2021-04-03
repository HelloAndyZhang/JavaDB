package SqlEngine.Parser;


/** *//**
 *
 * 单句插入语句解析器
 */
public class CreateDBSqlParser extends BaseSingleSqlParser{
    public CreateDBSqlParser(String originalSql) {
        super(originalSql);
    }
    @Override
    protected void initializeSegments() {
        segments.add(new SqlSegment("(create)(.+)(;)","[,]"));
        segments.add(new SqlSegment("(database)(.+)(;)","[;]"));

    }
    @Override
    public String getParsedSql() {
        String retval=super.getParsedSql();
        retval=retval+")";
        return retval;
    }
}