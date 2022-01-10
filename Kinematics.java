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
	
	
	//initial velocity methods
	public double ViFromTime() {
		vInitial = (-1 * acc * (0.5 * time));
		return vInitial;
	}
	
	public double ViFromMaxY(){
		vInitial = (this.VfFromRestGivenY()) * -1;
		return vInitial;
	}
	
	
	
	//final velocity formulas
	
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
	
	public double VfFromRestGivenY() {
		vFinal = -1 * Math.sqrt(Math.abs(2*acc*deltaY));
		return vFinal;
	}
	
	
	//solve for time methods
	
	public double timeSolveFFfromRest() {
		time = Math.sqrt((2 * Math.abs(deltaY)) / Math.abs(acc));
		return time;
	}
	
	public double timeSolveFFposVi() {
		time = (-2*vInitial)/acc;
		return time;
	}
	
	public double timeSolveViVf() {
		time = ((vFinal - vInitial)/acc);
		return time;
	}
	
	
	//solve for deltaY methods
	
	public double YsolveRestDT(){
		deltaY = ((1.0/2.0) * acc * (time*time));
		return deltaY;
	}
	
	public double highestFromVi() {
		
		
		if(vInitial > 0) {
			deltaY += ((0 - (vInitial * vInitial)/(2*acc))) * -1;
		}
		
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
	
	public double getDY() {
		return deltaY;
	}
	
	

}
