package eu.wisebed.wiseml.merger.internals.tree;

import eu.wisebed.wiseml.merger.internals.WiseMLAttribute;
import eu.wisebed.wiseml.merger.internals.WiseMLSequence;
import eu.wisebed.wiseml.merger.internals.WiseMLTag;

import java.util.List;

public interface WiseMLTreeReader {
	
	public boolean isList();
	public boolean isMappedToTag();
	
	public WiseMLTreeReader getSubElementReader();
	public boolean nextSubElementReader();
	public WiseMLTreeReader getParentReader();
	public boolean isFinished();
	
	public void exception(String message, Throwable throwable);

	// only if mapped to a specific WiseML-tag
	public List<WiseMLAttribute> getAttributeList();
	public WiseMLTag getTag();
	public String getText();
	
	// only if mapped to a sequence
	public WiseMLSequence getSequence();

}
