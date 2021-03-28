package SqlEngine.Parser;

/** *//**
*
* 单句删除语句解析器
*/
public class DeleteSqlParser extends BaseSingleSqlParser{
public DeleteSqlParser(String originalSql) {
    super(originalSql);
}
@Override
protected void initializeSegments() {
    segments.add(new SqlSegment("(delete from)(.+)( where | ENDOFSQL)","[,]"));
    segments.add(new SqlSegment("(where)(.+)( ENDOFSQL)","(and|or)"));
}
}