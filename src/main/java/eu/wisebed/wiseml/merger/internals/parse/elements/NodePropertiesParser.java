package eu.wisebed.wiseml.merger.internals.parse.elements;

import eu.wisebed.wiseml.merger.internals.WiseMLTag;
import eu.wisebed.wiseml.merger.internals.parse.ParserCallback;
import eu.wisebed.wiseml.merger.internals.parse.ParserHelper;
import eu.wisebed.wiseml.merger.internals.parse.WiseMLElementParser;
import eu.wisebed.wiseml.merger.internals.tree.WiseMLTreeReader;
import eu.wisebed.wiseml.merger.structures.Capability;
import eu.wisebed.wiseml.merger.structures.Coordinate;
import eu.wisebed.wiseml.merger.structures.NodeProperties;

public class NodePropertiesParser extends WiseMLElementParser<NodeProperties> {

	public NodePropertiesParser(WiseMLTreeReader reader) {
		super(reader);
	}

	@Override
	protected void parseStructure() {
		structure = new NodeProperties();
		ParserHelper.parseStructures(reader, new ParserCallback(){
			@Override
			public void nextStructure(WiseMLTag tag, Object obj) {
				switch (tag) {
				case position:
					structure.setPosition((Coordinate)obj);
					break;
				case gateway:
					structure.setGateway((Boolean)obj);
					break;
				case programDetails:
					structure.setProgramDetails((String)obj);
					break;
				case nodeType:
					structure.setNodeType((String)obj);
					break;
				case description:
					structure.setDescription((String)obj);
					break;
				case capability:
					structure.addCapability((Capability)obj);
					break;
				}
			}
		});
	}

}
