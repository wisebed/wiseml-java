package eu.wisebed.wiseml.merger.internals.tree.elements;

import eu.wisebed.wiseml.merger.internals.WiseMLTag;
import eu.wisebed.wiseml.merger.internals.tree.WiseMLTreeReader;
import eu.wisebed.wiseml.merger.structures.Coordinate;

public class OriginReader extends CoordinateReader {

	public OriginReader(WiseMLTreeReader parent, Coordinate coordinate) {
		super(parent, WiseMLTag.origin, coordinate);
	}

}
