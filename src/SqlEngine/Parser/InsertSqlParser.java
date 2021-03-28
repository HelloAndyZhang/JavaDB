package SqlEngine.Parser;

/** *//**
*
* 单句插入语句解析器
*/
public class InsertSqlParser extends BaseSingleSqlParser{
public InsertSqlParser(String originalSql) {
    super(originalSql);
}
@Override
protected void initializeSegments() {
    segments.add(new SqlSegment("(insert into)(.+)([(])","[,]"));
    segments.add(new SqlSegment("([(])(.+)( [)] values )","[,]"));
    segments.add(new SqlSegment("([)] values [(])(.+)( [)])","[,]"));
}
@Override
public String getParsedSql() {
    String retval=super.getParsedSql();
    retval=retval+")";
    return retval;
}
}