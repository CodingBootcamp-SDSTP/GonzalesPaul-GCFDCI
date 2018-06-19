public class SundayServices
{
	private String firstService;
	private String secondService;
	private String thirdService;
	private String fourthService;
	private int serviceTime;

	public SundayServices(String fs, String ss, String ts, String fours, int st) {
		firstService = fs;
		secondService = ss;
		thirdService = ts;
		fourthService = fours;
		serviceTime = st;
	}

	public String getFirstService() {
		return(firstService);
	}

	public void setFirstService(String fs) {
		firstService = fs;
	}

	public String getSecondService() {
		return(secondService);
	}

	public void setSecondService(String ss) {
		secondService = ss;
	}

	public String getThirdService() {
		return(thirdService);
	}

	public void setThirdService(String ts) {
		thirdService = ts;
	}

	public String getFourthService() {
		return(fourthService);
	}

	public void setFourthService(String fours) {
		fourthService = fours;
	}

	public int getServiceTime() {
		return(serviceTime);
	}

	public void setServiceTime(int st) {
		serviceTime = st;
	}
}
