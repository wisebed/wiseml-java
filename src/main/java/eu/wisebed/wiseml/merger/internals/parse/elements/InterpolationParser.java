package eu.wisebed.wiseml.merger.internals.parse.elements;

import eu.wisebed.wiseml.merger.enums.Interpolation;
import eu.wisebed.wiseml.merger.internals.parse.WiseMLElementParser;
import eu.wisebed.wiseml.merger.internals.tree.WiseMLTreeReader;

public class InterpolationParser extends WiseMLElementParser<Interpolation> {
	
	public InterpolationParser(WiseMLTreeReader reader) {
		super(reader);
	}

	@Override
	protected void parseStructure() {
		this.structure = Interpolation.valueOf(reader.getText());
	}

}
