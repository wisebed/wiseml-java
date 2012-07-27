package eu.wisebed.wiseml.merger.internals.parse.elements;

import eu.wisebed.wiseml.merger.internals.WiseMLTag;
import eu.wisebed.wiseml.merger.internals.tree.WiseMLTreeReader;


public class OriginParser extends CoordinateParser {

	public OriginParser(WiseMLTreeReader reader) {
		super(reader, WiseMLTag.origin);
	}

}
