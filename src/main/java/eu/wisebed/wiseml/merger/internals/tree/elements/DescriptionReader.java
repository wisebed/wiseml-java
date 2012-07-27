package eu.wisebed.wiseml.merger.internals.tree.elements;

import eu.wisebed.wiseml.merger.internals.WiseMLTag;
import eu.wisebed.wiseml.merger.internals.tree.WiseMLStructureReader;
import eu.wisebed.wiseml.merger.internals.tree.WiseMLTreeReader;

public class DescriptionReader extends WiseMLStructureReader {

	public DescriptionReader(WiseMLTreeReader parent, String description) {
		super(createPureTextElement(parent, WiseMLTag.description, description));
	}

}
