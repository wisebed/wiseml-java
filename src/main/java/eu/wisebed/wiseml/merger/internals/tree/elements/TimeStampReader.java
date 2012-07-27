package eu.wisebed.wiseml.merger.internals.tree.elements;

import eu.wisebed.wiseml.merger.internals.WiseMLTag;
import eu.wisebed.wiseml.merger.internals.tree.WiseMLStructureReader;
import eu.wisebed.wiseml.merger.internals.tree.WiseMLTreeReader;
import eu.wisebed.wiseml.merger.structures.TimeStamp;

public class TimeStampReader extends WiseMLStructureReader {

	public TimeStampReader(WiseMLTreeReader parent, TimeStamp timestamp) {
		super(new Element(
				parent, 
				WiseMLTag.timestamp, 
				null, 
				null,
				timestamp.toString()));
	}

}
