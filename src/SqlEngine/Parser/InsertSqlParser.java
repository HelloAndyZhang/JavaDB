package SqlEngine.Parser;

/**
*
* 单句插入语句解析器
*/
public class InsertSqlParser extends BaseSingleSqlParser{
public InsertSqlParser(String originalSql) {
    super(originalSql);
}
@Override
protected void initializeSegments() {
    // 不支持在指定列插入数据
//    segments.add(new SqlSegment("(insert into)(.+)([(])","[,]"));
//    segments.add(new SqlSegment("([(])(.+)( [)] values )","[,]"));
//    segments.add(new SqlSegment("([)] values [(])(.+)( [)])","[,]"));
    segments.add(new SqlSegment("(insert)(.+)(values)","[,]")); // 解析语法类型
    segments.add(new SqlSegment("(into)(.+)(values)","[,]"));
    segments.add(new SqlSegment("([(])(.+)([)])","[,]"));
}
@Override
public String getParsedSql() {
    String retval=super.getParsedSql();
    retval=retval+")";
    return retval;
}
}