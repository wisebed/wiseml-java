package eu.wisebed.wiseml.merger.internals.tree.elements;

import eu.wisebed.wiseml.merger.internals.WiseMLAttribute;
import eu.wisebed.wiseml.merger.internals.WiseMLTag;
import eu.wisebed.wiseml.merger.internals.tree.WiseMLStructureReader;
import eu.wisebed.wiseml.merger.internals.tree.WiseMLTreeReader;

public class CustomReader extends WiseMLStructureReader {

	public CustomReader(
			WiseMLTreeReader parent, 
			WiseMLTag tag, 
			WiseMLAttribute[] attributes, 
			String text) {
		super(new Element(parent, tag, attributes, null, text));
	}
	
	

}
