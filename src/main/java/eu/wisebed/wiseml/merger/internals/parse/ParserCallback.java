package eu.wisebed.wiseml.merger.internals.parse;

import eu.wisebed.wiseml.merger.internals.WiseMLTag;

public interface ParserCallback {
	void nextStructure(WiseMLTag tag, Object obj);
}
