package eu.wisebed.wiseml.merger.internals.parse.elements;

import eu.wisebed.wiseml.merger.enums.Unit;
import eu.wisebed.wiseml.merger.internals.parse.WiseMLElementParser;
import eu.wisebed.wiseml.merger.internals.tree.WiseMLTreeReader;

public class UnitParser extends WiseMLElementParser<Unit> {

	public UnitParser(WiseMLTreeReader reader) {
		super(reader);
	}

	@Override
	protected void parseStructure() {
		structure = Unit.valueOf(reader.getText());
	}

}
