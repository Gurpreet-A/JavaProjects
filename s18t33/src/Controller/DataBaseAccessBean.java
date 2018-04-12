package Controller;

public class DataBaseAccessBean {

	private String userName;
	private String passWord;
	private String dbHostName;
	private String dbSchema;
	private String sqlQuery;
	private String finalResult;
	private String connectionMessage;

	public String getConnectionMessage() {
		return connectionMessage;
	}

	public void setConnectionMessage(String connectionMessage) {
		this.connectionMessage = connectionMessage;
	}

	public DataBaseAccessBean(String userName, String passWord, String dbHostName, String dbSchema, String sqlQuery,
			String finalResult) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.dbHostName = dbHostName;
		this.dbSchema = dbSchema;
		this.sqlQuery = sqlQuery;
		this.finalResult = finalResult;
	}

	public DataBaseAccessBean() {

	}

	public String getFinalResult() {
		return finalResult;
	}

	public void setFinalResult(String finalResult) {
		this.finalResult = finalResult;
	}

	public String getSqlQuery() {
		return sqlQuery;
	}

	public void setSqlQuery(String sqlQuery) {
		this.sqlQuery = sqlQuery;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getDbHostName() {
		return dbHostName;
	}

	public void setDbHostName(String dbHostName) {
		this.dbHostName = dbHostName;
	}

	public String getDbSchema() {
		return dbSchema;
	}

	public void setDbSchema(String dbSchema) {
		this.dbSchema = dbSchema;
	}

}
