package eu.wisebed.wiseml.merger.internals.parse.elements;

import eu.wisebed.wiseml.merger.internals.WiseMLTag;
import eu.wisebed.wiseml.merger.internals.tree.WiseMLTreeReader;

public class PositionParser extends CoordinateParser {

	public PositionParser(WiseMLTreeReader reader) {
		super(reader, WiseMLTag.position);
	}

}
