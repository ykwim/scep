package it.polimi.scep15.stream.listeners;
import it.polimi.scep15.stream.events.RanksEvent;

import com.espertech.esper.client.EPRuntime;
import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;


public class CEPRankListener implements UpdateListener {

	EPRuntime cepRT;
	public void update(EventBean[] newData, EventBean[] oldData) {

		for(EventBean e : newData){
			RanksEvent r = (RanksEvent) e.getUnderlying();
			String res="pickup_datetime, dropoff_datetime, ";
			for(int i =0; i<r.getCurrentRank().size(); i++){
				res+=r.getCurrentRank().get(i)+", "+r.getPickupAreaCodes().get(i)+", ";
			}
			res+="delay";
			System.out.println("[New Rank] "+res);
		}
	}
	
	public EPRuntime getCepRT() {
		return cepRT;
	}
	public void setCepRT(EPRuntime cepRT) {
		this.cepRT = cepRT;
	}
}

