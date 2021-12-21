import java.lang.Math;


public class Kinematics {
	private double vInitial;
	private double vFinal;
	private double time;
	private double deltaY;
	private double acc;
	
	//creating a constructor for all data sets
	
	public Kinematics(double initial, double Final, double t, double changeY, double acceleration) {
		vInitial = initial;
		vFinal = Final;
		time = t;
		deltaY = changeY;
		acc = acceleration;
	} 
	
	//freefall problem methods
	
	
	public double vFinalNoY() {
		vFinal = vInitial + (acc * time);
		vFinal *= -1;
		
		return vFinal;
	}
	
	public double vF_from_vI_useY() {
		double vIntTemp = vInitial;
		
		
		if (vIntTemp > 0) {
			vIntTemp = 0;
		}
		
		vFinal = Math.sqrt((vIntTemp * vIntTemp) + 2*acc*deltaY) * -1;
		return vFinal;
	}
	
	
	//solve for time methods
	
	public double timeSolveFFfromRest() {
		time = Math.sqrt((2 * deltaY) / acc);
		return time;
	}
	
	public double timeSolveFFposVi() {
		;
		time = (-2*vInitial)/acc;
		return time;
	}
	
	public double timeSolveViVf() {
		time = ((vFinal - vInitial)/acc);
		return time;
	}
	
	
	//solve for deltaY methods
	
	
	//solving from rest with deltaT as given
	public double YsolveRestDT(){
		deltaY = ((1.0/2.0) * acc * (time*time));
		return deltaY;
	}
	
	public double highestFromVi() {
		deltaY += ((0 - (vInitial * vInitial)/(2*acc)));
		return deltaY;
	}
	
	
	
	//mutator methods
	
	public void setDeltaY(double newY) {
		deltaY = newY;
	}
	
	public void setVf(double VfMod) {
		vFinal = VfMod;
	}
	
	//accessor methods
	public double getVi() {
		return vInitial;
	}
	
	public double getVf() {
		return vFinal;
	}
	
	

}
