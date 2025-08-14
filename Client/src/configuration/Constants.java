package configuration;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Constants {

	public static class login {
		// version
		public static final long VERSION_NUM = 1L;
		// title
		public static final String TITLE = "Login system";
	        
		// frame size
		private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		public static final int WIDTH = screenSize.width;
		public static final int HEIGHT = screenSize.height;

		// login panel size
		public static final int LOGIN_PANEL_WIDTH = WIDTH / 6;

		// id field
		public static final String IDFIELD = "ID : ";
		public static final int ID_FIELD_LENGTH = 10;

		// pw field
		public static final String PWFIELD = "PW : ";
		public static final int PW_FIELD_LENGTH = 14;

		// login button
		public static final String BT = "LOGIN";

		// image panel size
		public static final int IMAGE_PANEL_WIDTH = WIDTH * 5 / 6;

		// image path
		public static final String IMAGE_PATH = "image/logo.png";
		public static final String BACKIMAGE_PATH = "image/background.png";
	}
	public class mainframe {
		//version
		final public static long VERSION_NUM=1L;	
		//title
		final public static String TITLE="수강신청";
		//size
		static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        public static int Width = screenSize.width * 2 / 3;
        public static int Height = screenSize.height * 2 / 3;
        public static int x = (screenSize.width - Width) / 2;
        public static int y = (screenSize.height - Height) / 2;
        final public static String LOGOUT="LOGOUT";
	}

	public class myinfo {
		//version
		final public static long VERSION_NUM=1L;
		final public static String NAME="NAME : ";
		final public static String SCORE="SCORE : ";
		final public static String BLAMK="        ";
		final public static String SLASH="/";
	}
	
	public class sugang {
		//version
		final public static long VERSION_NUM=1L;	
		
		final public static String BASKET="BASKET";
		final public static String SHOWBASKET="SHOWBASKET";
		final public static String SELECT="SELECT";
		final public static String SHOWSELECT="SHOWSELECT";
		final public static String SEARCH="SEARCH";
		final public static String SHOWSEARCH="SHOWSEARCH";
		final public static String MY="MY";
		final public static String SHOWMY="SHOWMY";
	}

	public static class indexTable {

		public enum EHeader {
            EID("id"),
            ETITLE("campus");
            private final String title;
            EHeader(String title) {this.title = title;}
            public String getTitle() {return this.title; }
		}
	}
	public class indexpanel {
		final public static long VERSION_NUM=1L;
		final public static String ROOT="root";
	}
	public class indextable{
		final public static long VERSION_NUM=1L;
	}
	public class lecture {
		final public static long VERSION_NUM=1L;
		public enum ElectureHeader {
            EID("id"),
            ETITLE("name"),
			EPRONAME("proname"),
			ESCORE("Score"),
			ETIME("Time"), 
			EDAY("DAY"), 
			EPEOPLE("CURRENT"), 
			EWISHPEOPLE("WISH"), 
			EPEOPLELIMIT("LIMIT");
			
            private final String title;
            ElectureHeader(String title) {this.title = title;}
            public String getTitle() {return this.title;}
		}
	}
	public static class controlbt{
		final public static long VERSION_NUM=1L;	
		final public static String BAKSET ="BAKSET";
		final public static String DELETEBASKET ="Delete BASKET";
		final public static String Enrollment ="Enrollment";
		public static final String DELETE = "DELETE";
	}
	public static class select{
		final public static long VERSION_NUM=1L;
	}
	public static class miri{
		final public static long VERSION_NUM=1L;
	}
	public static class my{
		final public static long VERSION_NUM=1L;
	}
	public static class search{
		final public static long VERSION_NUM=1L;
	}
}


