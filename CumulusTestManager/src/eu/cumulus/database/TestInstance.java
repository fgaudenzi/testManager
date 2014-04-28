package eu.cumulus.database;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The persistent class for the TestInstance database table.
 * 
 */
@Entity
@NamedQuery(name = "TestInstance.findAll", query = "SELECT t FROM TestInstance t")
public class TestInstance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int testInstanceID;

	private String TInst_ExpectedOutput;

	private String TInst_HiddenCommunication;

	private String TInst_Input;

	private String TInst_Operation;

	private String TInst_PostCondition;

	private String TInst_Precondition;

	// bi-directional one-to-one association to TestCase
	@ManyToOne
	@JoinColumn(name = "TestCaseID")
	private TestCase testCase;

	public TestInstance() {
	}

	public int getTestInstanceID() {
		return this.testInstanceID;
	}

	public void setTestInstanceID(int testInstanceID) {
		this.testInstanceID = testInstanceID;
	}

	public String getTInst_ExpectedOutput() {
		return this.TInst_ExpectedOutput;
	}

	public void setTInst_ExpectedOutput(String TInst_ExpectedOutput) {
		this.TInst_ExpectedOutput = TInst_ExpectedOutput;
	}

	public String getTInst_HiddenCommunication() {
		return this.TInst_HiddenCommunication;
	}

	public void setTInst_HiddenCommunication(String TInst_HiddenCommunication) {
		this.TInst_HiddenCommunication = TInst_HiddenCommunication;
	}

	public String getTInst_Input() {
		return this.TInst_Input;
	}

	public void setTInst_Input(String TInst_Input) {
		this.TInst_Input = TInst_Input;
	}

	public String getTInst_Operation() {
		return this.TInst_Operation;
	}

	public void setTInst_Operation(String TInst_Operation) {
		this.TInst_Operation = TInst_Operation;
	}

	public String getTInst_PostCondition() {
		return this.TInst_PostCondition;
	}

	public void setTInst_PostCondition(String TInst_PostCondition) {
		this.TInst_PostCondition = TInst_PostCondition;
	}

	public String getTInst_Precondition() {
		return this.TInst_Precondition;
	}

	public void setTInst_Precondition(String TInst_Precondition) {
		this.TInst_Precondition = TInst_Precondition;
	}

	public TestCase getTestCase() {
		return this.testCase;
	}

	public void setTestCase(TestCase testCase) {
		this.testCase = testCase;
	}

	/**
	 * @return
	 */
	public eu.cumulus.certModelXML.TestInstanceType toXMLObject() {
		eu.cumulus.certModelXML.TestInstanceType tit = new eu.cumulus.certModelXML.TestInstanceType();
		tit.setExpectedOutput(TInst_ExpectedOutput);
		tit.setHiddenCommunications(TInst_HiddenCommunication);
		tit.setInput(TInst_Input);
		tit.setOperation(TInst_Operation);
		tit.setPostConditions(this.TInst_PostCondition);
		tit.setPreconditions(this.TInst_PostCondition);
		return tit;
	}
}