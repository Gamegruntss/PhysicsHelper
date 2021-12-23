import java.util.Scanner;
import java.lang.Double;

public class main{
	
	public static String reqdOutput = "";
	public static int count = 0;
	
	//checks a if the return value is classified as unknown
	//if it is then it will return 0 otherwise it returns the double value of the string
	
	public static double equalCheck(String str) {
		
		if(str.equals("unknown")) {
			return 0;
		} else {
			return Double.valueOf(str); 
		}		
	}
	
	
	public static double roundTwo(double round) {
		return (Math.round(round* 100.0)/100.0);
	}
	
	//creation of the main class
	
	public static void main(String[] args) {
				
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		double Vi = GUI.initialVelocity;
		double Vf = GUI.finalVelocity;
		double deltaT = GUI.deltaT;
		double deltaY = GUI.deltaY;
		double acc = GUI.acceleration;
		
		String initialVelOutput = "The initial velocity is ";
		String timeOutput = "The change in time is ";
		String finalVelOutput = "The final velocity is ";
		String deltaYOutput = "The change in height is ";
		
		Kinematics k = new Kinematics(Vi, Vf, deltaT, deltaY, acc);		
		
		
		//all outputs for initial velocity
		
		if(GUI.iniVboo && GUI.dtGive) {
			initialVelOutput += roundTwo(k.ViFromTime());
		}
		
		if(GUI.iniVboo && GUI.dyGiven && !GUI.dtGive) {
			initialVelOutput += roundTwo(k.ViFromMaxY());
		}
		
		
		initialVelOutput += " m/s.";
		
		
		//all outputs for final velocity
		
		if(GUI.finVboo && GUI.dyGiven) {
			k.setDeltaY(k.highestFromVi());
			finalVelOutput += roundTwo(k.vF_from_vI_useY());
			k.setVf(k.vF_from_vI_useY());
		}
				
		if (GUI.finVboo && GUI.ViGive && !GUI.dyGiven) {
			finalVelOutput += roundTwo(k.vFinalNoY());
					
		}
				
		finalVelOutput += " m/s.";
				
		
		//all outputs for if time is required
		
		
		
		if(GUI.dTboo && GUI.dyGiven && !GUI.ViGive && !GUI.iniVboo) {
			timeOutput += Math.abs(roundTwo(k.timeSolveFFfromRest()));
		} else if(GUI.dTboo && GUI.ViGive && !GUI.dyGiven) {
			timeOutput += Math.abs(roundTwo(k.timeSolveFFposVi()));
		} else if(GUI.dTboo && GUI.ViGive && GUI.dyGiven && Vi > 0) {
			timeOutput += Math.abs(roundTwo((0.5 * k.timeSolveFFposVi()) + k.timeSolveFFfromRest()));
		} else if(GUI.dTboo && k.getVf() != 0) {
			timeOutput += Math.abs(roundTwo(k.timeSolveViVf())); 
		} /*else if(GUI.dTboo && GUI.iniVboo) {
			timeOutput += ;
		}*/
		
		timeOutput += " seconds.";
		
		
		//all out puts for if deltaY is required
		
		if(GUI.dYboo && ((!GUI.ViGive) || Vi == 0 ) && !GUI.iniVboo && GUI.dtGive) {
			deltaYOutput += roundTwo(k.YsolveRestDT());
		}
		
		if(GUI.dYboo && (GUI.ViGive || k.getVi() > 0) && !GUI.dtGive) {
			deltaYOutput += roundTwo(k.highestFromVi());
		}
		
		deltaYOutput += " meters.";
		
		
		reqdOutput = "";
		//finalizations
		
		if(GUI.iniVboo) {
			reqdOutput += initialVelOutput + "\n";
			count++;
		}

		if(GUI.finVboo) {
			reqdOutput += finalVelOutput + "\n";
			count++;
		}
		
		
		if(GUI.dTboo) {
			reqdOutput += timeOutput + "\n";
			count++;
		}
		
		if(GUI.dYboo) {
			reqdOutput += deltaYOutput + "\n";
			count++;
		}
		
		//System.out.println(reqdOutput);
		
	
	}
}
