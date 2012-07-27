package eu.wisebed.wiseml.merger.internals.parse.elements;

import eu.wisebed.wiseml.merger.internals.WiseMLTag;
import eu.wisebed.wiseml.merger.internals.parse.ParserCallback;
import eu.wisebed.wiseml.merger.internals.parse.ParserHelper;
import eu.wisebed.wiseml.merger.internals.parse.WiseMLElementParser;
import eu.wisebed.wiseml.merger.internals.tree.WiseMLTreeReader;
import eu.wisebed.wiseml.merger.structures.Capability;
import eu.wisebed.wiseml.merger.structures.LinkProperties;
import eu.wisebed.wiseml.merger.structures.RSSI;

public class LinkPropertiesParser extends WiseMLElementParser<LinkProperties> {

	public LinkPropertiesParser(WiseMLTreeReader reader) {
		super(reader);
	}

	@Override
	protected void parseStructure() {
		structure = new LinkProperties();
		ParserHelper.parseStructures(reader, new ParserCallback(){
			@Override
			public void nextStructure(WiseMLTag tag, Object obj) {
				switch (tag) {
				case encrypted:
					structure.setEncrypted((Boolean)obj);
					break;
				case virtual:
					structure.setVirtual((Boolean)obj);
					break;
				case rssi:
					structure.setRssi((RSSI)obj);
					break;
				case capability:
					structure.addCapability((Capability)obj);
					break;
				}
			}
		}); 
	}

}
