package SqlEngine.Parser;

import java.util.List;

/** */
/**
 * 单句Sql解析器制造工厂
 *
 */
public class SqlParserUtil {
	/** */
	/**
	 * 方法的主要入口 @param sql:要解析的sql语句 @return 返回解析结果
	 */
	public String getParsedSql(String sql) {
		sql = formatSqlStr(sql);
		// System.out.println(sql);
		return SingleSqlParserFactory.generateParser(sql).getParsedSql();
	}

	/** */
	/**
	 * SQL语句解析的接口 @param sql:要解析的sql语句 @return 返回解析结果
	 */
	public List<SqlSegment> getParsedSqlList(String sql) {
		sql = formatSqlStr(sql);
		// System.out.println(sql);
		return SingleSqlParserFactory.generateParser(sql).RetrunSqlSegments();
	}

	private String formatSqlStr(String sqlStr){
		if (sqlStr == null || sqlStr.equals("")){
			throw new RuntimeException("sql not empty");
		}
		return ""
				+ (sqlStr
					.trim()
					.toLowerCase()
					.replaceAll("\\s{1,}", " "))
				+ " ENDOFSQL";
	}
}