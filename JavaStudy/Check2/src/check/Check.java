package check;
import constants.Constants;

public class Check {
	private String firstName = "蛭間";
	private String lastName = "寛大";
	private void printName() {
		System.out.println("printNameメソッド → " + firstName + lastName);
	}
	
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Check i = new Check();
		i.printName();
		Pet pet = new Pet(Constants.CHECK_CLASS_JAVA, Constants.CHECK_CLASS_HOGE);
		pet.introduce();
		RobotPet rb = new RobotPet(Constants.CHECK_CLASS_R2D2, Constants.CHECK_CLASS_LUKE);
		rb.introduce();
	}
}
