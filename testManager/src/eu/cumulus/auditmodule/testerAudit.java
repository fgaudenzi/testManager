package eu.cumulus.auditmodule;

import java.util.Date;

import cumulus.components.auditing.client.xmpp.CumulusEventSerialized;
import cumulus.xmpp.sender.Sender;

public class testerAudit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Thread(new Runnable() {
			public void run() {

				Sender send = new Sender();
				Date date = new Date();
				CumulusEventSerialized event = new CumulusEventSerialized(
						"testBasedCertificate",
						"collector_update",
						"certification/evidence", date, 0, "", "", "", "", "",
						0, "", "", "", "");

				send.sendAuditEvent(event, "/Users/iridium/Documents/workspace/testManager/testManager/AUDIT_PROPERTIES/openfire.properties");
			}
		}).start();
	}
}
