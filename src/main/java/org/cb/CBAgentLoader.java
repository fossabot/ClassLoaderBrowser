package org.cb;
import java.lang.instrument.instrumentation.*;
import com.sun.tools.attach.VirtualMachine;

/**
 * An Utility to display the Classloaders & classes loaded by a JVM Process at Runtime
 * Implements Agent loading for Hotspot and IBM JDK
 */

public class CBAgentLoader
{
	public static void loadAgent() {
		String nameofRunningVM = ManagementFactory.getRuntimeMXBean().getName();
		int p = nameofRunningVM.indexOf('@');
		String pid = nameofRunningVM.substring(0,p);
		try {
			VirtualMachine vm  = VirtualMachine.attach(pid);
			vm.loadAgent(jarFilePath, "");
			vm.detach();
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

}
