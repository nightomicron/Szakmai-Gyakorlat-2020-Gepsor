package RuntimeCalc;

public class LabelException extends Exception{
	private String label;
	public LabelException(String l){
		label = l;
	}
	public String getLabel(){
		return label;
	}

}
