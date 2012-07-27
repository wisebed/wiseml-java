package eu.wisebed.wiseml.merger.internals.parse;

import eu.wisebed.wiseml.merger.internals.WiseMLTag;
import eu.wisebed.wiseml.merger.internals.tree.WiseMLTreeReader;

public abstract class WiseMLElementParser<T> {
	
	protected WiseMLTreeReader reader;
	protected T structure;
	
	public WiseMLElementParser(final WiseMLTreeReader reader) {
		this.reader = reader;
		this.structure = null;
 	}
	
	public T getParsedStructure() {
		if (structure == null) {
			parseStructure();
		}
		return structure;
	}
	
	protected abstract void parseStructure();

	protected static void assertTag(WiseMLTreeReader reader, WiseMLTag tag) {
		if (!tag.equals(reader.getTag())) {
			throw new RuntimeException("expected <"+tag.getLocalName()+">, got <"+reader.getTag()+">");
		}
	}

}
