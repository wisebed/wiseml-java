package eu.wisebed.wiseml.merger.internals.tree.elements;

import eu.wisebed.wiseml.merger.enums.Interpolation;
import eu.wisebed.wiseml.merger.internals.WiseMLTag;
import eu.wisebed.wiseml.merger.internals.tree.WiseMLStructureReader;
import eu.wisebed.wiseml.merger.internals.tree.WiseMLTreeReader;

public class InterpolationReader extends WiseMLStructureReader {

	public InterpolationReader(
			final WiseMLTreeReader parent, 
			final Interpolation interpolation) {
		super(createPureTextElement(parent, WiseMLTag.interpolation, interpolation.name()));
	}

}
