package neusoft.test;

import java.util.UUID;

import org.apache.ibatis.jdbc.SQL;

public class SqlTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(new SqlTest().selectPersonSql());
		// String uuid = UUID.randomUUID().toString().replace("-", "");
		String uuid = UUID.randomUUID().toString();
		System.out.println(uuid);
	}

	@SuppressWarnings("unused")
	private String selectPersonSql() {
		return new SQL() {
			{
				SELECT("P.ID, P.USERNAME, P.PASSWORD, P.FULL_NAME");
				SELECT("P.LAST_NAME, P.CREATED_ON, P.UPDATED_ON");
				FROM("PERSON P");
				FROM("ACCOUNT A");
				INNER_JOIN("DEPARTMENT D on D.ID = P.DEPARTMENT_ID");
				INNER_JOIN("COMPANY C on D.COMPANY_ID = C.ID");
				WHERE("P.ID = A.ID");
				WHERE("P.FIRST_NAME like ?");
				OR();
				WHERE("P.LAST_NAME like ?");
				GROUP_BY("P.ID");
				HAVING("P.LAST_NAME like ?");
				OR();
				HAVING("P.FIRST_NAME like ?");
				ORDER_BY("P.ID");
				ORDER_BY("P.FULL_NAME");
			}
		}.toString();
	}
}
