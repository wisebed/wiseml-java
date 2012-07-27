package eu.wisebed.wiseml.merger.internals.tree.elements;

import eu.wisebed.wiseml.merger.internals.WiseMLAttribute;
import eu.wisebed.wiseml.merger.internals.WiseMLTag;
import eu.wisebed.wiseml.merger.internals.tree.WiseMLStructureReader;
import eu.wisebed.wiseml.merger.internals.tree.WiseMLTreeReader;
import eu.wisebed.wiseml.merger.structures.LinkTraceItem;

public class LinkTraceItemReader extends WiseMLStructureReader {

	public LinkTraceItemReader(
			final WiseMLTreeReader parent, 
			final LinkTraceItem linkTraceItem) {
		super(new Element(
				parent, 
				WiseMLTag.link,
				new WiseMLAttribute[]{
					new WiseMLAttribute("source", linkTraceItem.getSource()),
					new WiseMLAttribute("target", linkTraceItem.getTarget()),
				},
				createSubElements(linkTraceItem),
				null));
	}

	private static Element[] createSubElements(LinkTraceItem linkTraceItem) {
		int offset = linkTraceItem.getRssi() != null ? 1 : 0;
		Element[] result = new Element[linkTraceItem.dataItemCount() + offset];
		
		if (offset > 0) {
			result[0] = createPureTextElement(
					null, WiseMLTag.rssi, linkTraceItem.getRssi());
		}
		
		for (int i = 0; i < result.length - offset; i++) {
			result[offset + i] = new Element(
					null,
					WiseMLTag.data,
					new WiseMLAttribute[]{
						new WiseMLAttribute("key", linkTraceItem.getKey(i)),
					},
					null,
					linkTraceItem.getData(i));
		}
		
		return result;
	}

}
