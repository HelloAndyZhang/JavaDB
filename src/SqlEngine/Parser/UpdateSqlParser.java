package SqlEngine.Parser;

/** *//**
*
* 单句更新语句解析器
*/
public class UpdateSqlParser extends BaseSingleSqlParser{
public UpdateSqlParser(String originalSql) {
    super(originalSql);
}
@Override
protected void initializeSegments() {
    segments.add(new SqlSegment("(update)(.+)(set)","[,]"));
    segments.add(new SqlSegment("(set)(.+)( where | ENDOFSQL)","[,]"));
    segments.add(new SqlSegment("(where)(.+)( ENDOFSQL)","(and|or)"));
}
}