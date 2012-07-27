package eu.wisebed.wiseml.merger.internals.tree.elements;

import eu.wisebed.wiseml.merger.internals.WiseMLTag;
import eu.wisebed.wiseml.merger.internals.tree.WiseMLStructureReader;
import eu.wisebed.wiseml.merger.internals.tree.WiseMLTreeReader;
import eu.wisebed.wiseml.merger.structures.LinkProperties;
import eu.wisebed.wiseml.merger.structures.NodeProperties;

public class DefaultsReader extends WiseMLStructureReader {

	public DefaultsReader(
			final WiseMLTreeReader parent, 
			final NodeProperties nodeProperties, 
			final LinkProperties linkProperties) {
		super(new Element(
				parent, 
				WiseMLTag.defaults, 
				null, 
				createSubElementsFromReaders(
						((nodeProperties != null)?
							new NodePropertiesReader(null, nodeProperties)
						:
							null),
						((linkProperties != null)?
							new LinkPropertiesReader(null, linkProperties)
						:
							null)),
				null));
	}

}
