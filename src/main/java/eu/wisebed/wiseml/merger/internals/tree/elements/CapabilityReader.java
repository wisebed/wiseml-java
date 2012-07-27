package eu.wisebed.wiseml.merger.internals.tree.elements;

import eu.wisebed.wiseml.merger.internals.WiseMLTag;
import eu.wisebed.wiseml.merger.internals.tree.WiseMLStructureReader;
import eu.wisebed.wiseml.merger.internals.tree.WiseMLTreeReader;
import eu.wisebed.wiseml.merger.structures.Capability;

public class CapabilityReader extends WiseMLStructureReader {

	public CapabilityReader(WiseMLTreeReader parent, Capability capability) {
		super(new Element(
				parent,
				WiseMLTag.capability,
				null,
				new Element[]{
						createPureTextElement(
								null, 
								WiseMLTag.name, 
								capability.getName()),
						createPureTextElement(
								null, 
								WiseMLTag.dataType, 
								capability.getDataType().toString()),
						createPureTextElement(
								null, 
								WiseMLTag.unit, 
								capability.getUnit().toString()),
						createPureTextElement(
								null, 
								WiseMLTag.capabilityDefaultValue, 
								capability.getDefaultValue()),
				},
				null));
	}

}
