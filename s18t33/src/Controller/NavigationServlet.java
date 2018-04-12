package Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DbServlet
 */
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
		HttpSession session = request.getSession();
	   	String finalResult=null;
	   	String sqlQuery=null;
	   	DataBaseAccessBean dbAccess= (DataBaseAccessBean)session.getAttribute("dbAccess");
		DataBaseDAO        dbDAO=new DataBaseDAO ();
		String actionValue =request.getParameter("action");
		if(actionValue.equalsIgnoreCase("login"))
		{
		dbAccess.setUserName(request.getParameter("userName"));
	    dbAccess.setPassWord(request.getParameter("passWord"));
	    dbAccess.setDbHostName(request.getParameter("dbHostName"));
	    DataBaseDAO.setUserDetails(dbAccess);
		if(DataBaseDAO.getConnection()==null)
		{
			RequestDispatcher dispatcher =request.getRequestDispatcher("/jsp/login.jsp");
			dispatcher.forward(request, response);
			
			dbAccess.setConnectionMessage("connection failure");
			
			
		}
		
		else
		{
			dbAccess.setConnectionMessage("Success");
			RequestDispatcher dispatcher =request.getRequestDispatcher("/jsp/dataBaseAccessMenu.jsp");
			dispatcher.forward(request, response);
			
		}
		}
		else if(actionValue.equalsIgnoreCase("executeQuery"))
		{
		if(dbAccess.getConnectionMessage().equalsIgnoreCase("success"))
			{
			sqlQuery =request.getParameter("sqlQuery")+";";
		    finalResult=dbDAO.displayResults(sqlQuery);
			System.out.println(sqlQuery);
			dbAccess.setFinalResult(finalResult);
			dbAccess.setSqlQuery(sqlQuery);
			System.out.println(request.getContextPath());
			RequestDispatcher dispatcher =request.getRequestDispatcher("/jsp/dataBaseAccessMenu.jsp");
			dispatcher.forward(request, response);
			}
			
			else
			{
				RequestDispatcher dispatcher =request.getRequestDispatcher("/jsp/login.jsp");
				dispatcher.forward(request, response);
				dbAccess.setConnectionMessage("Connection Error");
			}
		}
		else
		{
			RequestDispatcher dispatcher =request.getRequestDispatcher("/jsp/login.jsp");
		dispatcher.forward(request, response);
		
		
		
		
	}

}}
