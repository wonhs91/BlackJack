package main.java.model;

public enum Decision {
	NO_DECISION,
	HIT,
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
