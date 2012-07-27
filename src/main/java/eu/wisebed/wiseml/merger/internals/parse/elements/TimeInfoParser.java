package eu.wisebed.wiseml.merger.internals.parse.elements;

import eu.wisebed.wiseml.merger.enums.Unit;
import eu.wisebed.wiseml.merger.internals.WiseMLTag;
import eu.wisebed.wiseml.merger.internals.parse.WiseMLElementParser;
import eu.wisebed.wiseml.merger.internals.tree.WiseMLTreeReader;
import eu.wisebed.wiseml.merger.structures.TimeInfo;

public class TimeInfoParser extends WiseMLElementParser<TimeInfo> {

	public TimeInfoParser(WiseMLTreeReader reader) {
		super(reader);
	}

	@Override
	protected void parseStructure() {
		reader.nextSubElementReader(); // <start>
		String start = reader.getSubElementReader().getText();
		
		reader.nextSubElementReader(); // <end> or <duration>
		boolean endDefined = (reader.getSubElementReader().getTag().equals(WiseMLTag.end));
		String end = null;
		long duration = 0;
		if (endDefined) {
			end = reader.getSubElementReader().getText();
		} else {
			duration = Long.parseLong(reader.getSubElementReader().getText());
		}
		
		reader.nextSubElementReader(); // <unit>
		Unit unit = Unit.valueOf(reader.getSubElementReader().getText());
		
		if (endDefined) {
			this.structure = new TimeInfo(start, end, unit);
		} else {
			this.structure = new TimeInfo(start, duration, unit);
		}
	}

}
