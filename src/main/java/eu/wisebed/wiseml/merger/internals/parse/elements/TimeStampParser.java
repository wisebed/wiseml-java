package eu.wisebed.wiseml.merger.internals.parse.elements;

import eu.wisebed.wiseml.merger.internals.parse.WiseMLElementParser;
import eu.wisebed.wiseml.merger.internals.tree.WiseMLTreeReader;
import eu.wisebed.wiseml.merger.structures.TimeInfo;
import eu.wisebed.wiseml.merger.structures.TimeStamp;
import org.joda.time.DateTime;

public class TimeStampParser extends WiseMLElementParser<TimeStamp> {

	private TimeInfo timeInfo;
	
	public TimeStampParser(WiseMLTreeReader reader, TimeInfo timeInfo) {
		super(reader);
		this.timeInfo = timeInfo;
	}

	@Override
	protected void parseStructure() {
		try {
			structure = new TimeStamp(
					Integer.parseInt(reader.getText()), 
					timeInfo.getUnit(), 
					timeInfo.getStart());
		} catch (NumberFormatException e) {
			structure = new TimeStamp(
					new DateTime(reader.getText()),
					timeInfo.getUnit(),
					timeInfo.getStart());
		}
	}

}
