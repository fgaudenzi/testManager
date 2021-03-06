package eu.cumulus.Persistence.DBtables;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TESTINSTANCE database table.
 * 
 */
@Entity
@Table(name="TESTINSTANCE")
@NamedQuery(name="Testinstance.findAll", query="SELECT t FROM Testinstance t")
public class Testinstance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int testInstanceID;

	@Column(length=256)
	private String TInst_ExpectedOutput;

	@Column(length=256)
	private String TInst_HiddenCommunication;

	@Column(length=256)
	private String TInst_Input;

	@Column(length=45)
	private String TInst_Operation;

	@Column(length=256)
	private String TInst_PostCondition;

	@Column(length=45)
	private String TInst_Precondition;

	//bi-directional many-to-one association to Testcase
	@ManyToOne
	@JoinColumn(name="TestCaseID")
	private Testcase testcase;

	public Testinstance() {
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

	public Testcase getTestcase() {
		return this.testcase;
	}

	public void setTestcase(Testcase testcase) {
		this.testcase = testcase;
	}

}