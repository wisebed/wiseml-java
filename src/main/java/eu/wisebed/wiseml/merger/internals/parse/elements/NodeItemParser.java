package eu.wisebed.wiseml.merger.internals.parse.elements;

import eu.wisebed.wiseml.merger.internals.WiseMLTag;
import eu.wisebed.wiseml.merger.internals.parse.WiseMLElementParser;
import eu.wisebed.wiseml.merger.internals.tree.WiseMLTreeReader;
import eu.wisebed.wiseml.merger.internals.tree.WiseMLTreeReaderHelper;
import eu.wisebed.wiseml.merger.structures.NodeItem;

public class NodeItemParser extends WiseMLElementParser<NodeItem> {

	public NodeItemParser(WiseMLTreeReader reader) {
		super(reader);
	}

	@Override
	protected void parseStructure() {
		this.structure = new NodeItem(
				WiseMLTreeReaderHelper.getAttributeValue(
						this.reader.getAttributeList(), "id"));
		while (this.reader.nextSubElementReader()) {
			WiseMLTreeReader next = this.reader.getSubElementReader();
			switch (next.getTag()) {
			case position: {
				CoordinateParser parser = new CoordinateParser(
						next, WiseMLTag.position);
				this.structure.setPosition(parser.getParsedStructure());
			}	break;
			case data: {
				String key = WiseMLTreeReaderHelper.getAttributeValue(
						next.getAttributeList(), "key");
				String data = reader.getText();
				this.structure.addDataItem(key, data);
			}	break;
			default:
				this.reader.exception("unexpected tag: "+next.getTag(), null);
			}
		}
	}

}
