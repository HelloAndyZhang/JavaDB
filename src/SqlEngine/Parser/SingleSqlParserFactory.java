package SqlEngine.Parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 单句Sql解析器制造工厂
 */
public class SingleSqlParserFactory {
	public static BaseSingleSqlParser generateParser(String sql) {
		if (contains(sql, "(insert into)(.+)(select)(.+)(from)(.+)")) {
			return new InsertSelectSqlParser(sql);
		} else if (contains(sql, "(select)(.+)(from)(.+)")) {
			return new SelectSqlParser(sql);
		} else if (contains(sql, "(delete from)(.+)")) {
			return new DeleteSqlParser(sql);
		} else if (contains(sql, "(update)(.+)(set)(.+)")) {
			return new UpdateSqlParser(sql);
		} else if (contains(sql, "(insert into)(.+)(values)(.+)")) {
			return new InsertSqlParser(sql);
		} else if (contains(sql, "(create table)(.+)")) {
			return new CreateTbSqlParser(sql);
		} else if (contains(sql, "(create database)(.+)")) {
			return new CreateDBSqlParser(sql);
		} else if (contains(sql, "(use)(.+)")) {
			return new UseSqlParser(sql);
		} else {
			return new InsertSqlParser(sql);
		}
	}

	/**
	 * 看word是否在lineText中存在，支持正则表达式 @param sql:要解析的sql语句 @param regExp:正则表达式 @return
	 */
	private static boolean contains(String sql, String regExp) {
		Pattern pattern = Pattern.compile(regExp, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(sql);
		return matcher.find();
	}
}