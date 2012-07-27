package eu.wisebed.wiseml.merger.internals.tree;

import eu.wisebed.wiseml.merger.internals.WiseMLAttribute;

import java.util.List;


public class WiseMLTreeReaderHelper {
	
	public static void skipToEnd(final WiseMLTreeReader reader) {
		while (!reader.isFinished()) {
			reader.nextSubElementReader();
		}
	}
	
	public static String getAttributeValue(
			final List<WiseMLAttribute> attributes, 
			final String attributeName) {
		for (WiseMLAttribute attribute : attributes) {
			if (attribute.getName().equals(attributeName)) {
				return attribute.getValue();
			}
		}
		return null;
	}

}
