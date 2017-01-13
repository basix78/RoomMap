package de.tunetown.roommap.main;

public class ThreadManagement {

	private int cpusPrecalculation;
	private int cpusInterpolation;
	
	public ThreadManagement() {
		int cpus = Runtime.getRuntime().availableProcessors();
		if (cpus >= 8) {
			// Medium scale
			cpusPrecalculation = (cpus - 2) / 2;   
			cpusInterpolation = cpus - 2;
		} else {
			if (cpus >= 4) {
				// Medium scale
				cpusPrecalculation = cpus / 2;   
				cpusInterpolation = cpus - 1;
			} else {
				// CPU minimum
				cpusPrecalculation = 0; // No precalculation  
				cpusInterpolation = 1;  // No multithreaded interpolation
			}
		}
	}
	
	public int getNumOfProcessorsInterpolation() {
		return cpusInterpolation;
	}
	
	public int getNumOfProcessorsInterpolatorPrecalculation() {
		return cpusPrecalculation;
	}
}
