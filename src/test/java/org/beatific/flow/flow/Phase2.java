package org.beatific.flow.flow;

import org.beatific.flow.phase.Phase;
import org.beatific.flow.phase.PhaseExecutor;
import org.springframework.beans.factory.annotation.Autowired;

@Phase(id="test", order=2, fixedDelay=1)
public class Phase2 extends PhaseExecutor {

	@Autowired
	private Shared shared;
	
	@Override
	protected void innerExecute() throws Exception {
		store.save(this);
		switch(shared.getValue()) {
		case 1 : shared.setValue(2); break;
		default : break;
		}
	}
}
