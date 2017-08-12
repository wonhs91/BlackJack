package main.java.model;

public enum Decision {
	HIT,
	FOLD,
	STAND,
	SPLIT,
	DOUBLE;

	public static boolean contains(String strDecision){
		for (Decision decision : Decision.values()){
			if (decision.name().equals(strDecision)){
				return true;
			}
		}
		return false;
	}
}
