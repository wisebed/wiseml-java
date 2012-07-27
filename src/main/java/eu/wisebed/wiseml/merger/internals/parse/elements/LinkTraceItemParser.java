package eu.wisebed.wiseml.merger.internals.parse.elements;

import eu.wisebed.wiseml.merger.internals.parse.WiseMLElementParser;
import eu.wisebed.wiseml.merger.internals.tree.WiseMLTreeReader;
import eu.wisebed.wiseml.merger.internals.tree.WiseMLTreeReaderHelper;
import eu.wisebed.wiseml.merger.structures.LinkTraceItem;

public class LinkTraceItemParser extends WiseMLElementParser<LinkTraceItem> {

	public LinkTraceItemParser(WiseMLTreeReader reader) {
		super(reader);
	}

	@Override
	protected void parseStructure() {
		structure = new LinkTraceItem(
				WiseMLTreeReaderHelper.getAttributeValue(
						reader.getAttributeList(), "source"),
				WiseMLTreeReaderHelper.getAttributeValue(
						reader.getAttributeList(), "target"));
		while (reader.nextSubElementReader()) {
			switch (reader.getSubElementReader().getTag()) {
			case rssi:
				structure.setRssi(reader.getSubElementReader().getText());
				break;
			case data:
				structure.addDataItem(
						WiseMLTreeReaderHelper.getAttributeValue(
								reader.getSubElementReader().getAttributeList(), 
								"key"),
						reader.getSubElementReader().getText());
				break;
			}
		}
	}

}
