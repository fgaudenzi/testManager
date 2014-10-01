package eu.cumulus.testingpkg;

import eu.cumulus.utilities.TestManagerHelperMethods;

public class ParallelTester {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		TestManagerHelperMethods tm=new TestManagerHelperMethods("/Users/iridium/Jobs/pythonAgents/testmanager.properties");
		eu.cumulus.init.RabbitConsumer rc=new eu.cumulus.init.RabbitConsumer();
		rc.addAgent("agent1");
		rc.run();

	}

}
