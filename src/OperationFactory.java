import javafx.scene.control.Button;

public class OperationFactory {
	
	public Operation getOperation(String string){
		if(string == null){
			return null;
		}
		
		else if(string.equalsIgnoreCase("+")){
			return new Add();
		}
		
		else if(string.equalsIgnoreCase("-")){
			return new Subtract();
		}
		
		return null;
	}
}
