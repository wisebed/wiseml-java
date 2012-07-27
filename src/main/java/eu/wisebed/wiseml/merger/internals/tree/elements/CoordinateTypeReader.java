package eu.wisebed.wiseml.merger.internals.tree.elements;

import eu.wisebed.wiseml.merger.internals.WiseMLTag;
import eu.wisebed.wiseml.merger.internals.tree.WiseMLStructureReader;
import eu.wisebed.wiseml.merger.internals.tree.WiseMLTreeReader;


public class CoordinateTypeReader extends WiseMLStructureReader {

	public CoordinateTypeReader(
			final WiseMLTreeReader parent, 
			final String coordinateType) {
		super(createPureTextElement(parent, WiseMLTag.coordinateType, coordinateType));
	}

}
