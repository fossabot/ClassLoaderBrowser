package org.cb;
import java.lang.instrument.instrumentation.*;
/**
 * An Utility to display the Classloaders & classes loaded by a JVM Process at Runtime
 *
 */
public class CBAgent
{
	private static Instrumentation instrumentation;

	public static void agentmain(String agentArgs, Instrumentation inst) {
		System.out.println("ClassloadBrowser Agent attached...")
		instrumentation = inst;
	}
	public static void initialize() {
		if (instrumentation == null) {
			CBAgentLoader.loadAgent();
		}
	}
}
