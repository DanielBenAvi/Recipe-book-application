package Model;

public class Step {
	private int num;
	private String step;

	public Step(int num, String step) {
		this.num = num;
		this.step = step;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	@Override
	public String toString() {
		String string = "";
		string = string + num + ")  ";
		string = string + step + "\n ";

		return string;
	}

}
