package experiments;
import java.util.Date;
public class DemoClass {

	public static void main(String[] args) {
		Date date= new Date();
		System.out.println(date.toString().replace(" ","_").replace(":","_"));
		//String dateText= date.toString();
		//String dateTestWithoutSpace=dateText.replace(" ","_");
		//String dateTestWithoutSpaceAndColon=dateTestWithoutSpace.replace(":","_");
		//System.out.println(dateTestWithoutSpaceAndColon);

	}

}
